public class LazyPropogation {
	static long[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20 };
	static int c = 0;

	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		Node node = new Node(0, A.length - 1);
		node.update(node, 0, A.length - 1, 0, 19, 10);
		System.out.println(node.answer(node, 0, A.length - 1, 0, 9));
		System.out.println(c);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}

	static class Node {
		int from, to;
		long sum = 0;
		Node left;
		Node right;
		long lazy = 0;
		Node(int from, int to) {
			this.from = from;
			this.to = to;
			if (from == to) {
				sum = A[from];
			} else {
				int mid = (from + to) / 2;
				left = new Node(from, mid);
				right = new Node(mid + 1, to);
				sum = left.sum + right.sum;
			}
		}

		void update(Node node, int a, int b, int L, int R, long value) {
			// System.out.println(node.lazy);
			if (node.lazy != 0) {
				node.sum += (node.lazy) * (b - a + 1);
				if (a != b) {
					node.left.lazy += node.lazy;
					node.right.lazy += node.lazy;
				}
				node.lazy = 0;
			}
			
			if (a > b || a > R || b < L) {
				return;
			}
			if (a >= L && b <= R) {
				node.sum += ((value) * (b - a + 1));
				if (a != b) {
					node.left.lazy += value;
					node.right.lazy += value;
					// System.out.println(a+" "+b+" "+node.left.lazy+" "+node.right.lazy+" "+node.left.sum+" "+node.right.sum);
				}
				return;
			}
			//System.out.println(a + " " + b + " " + node.sum + " "+ node.left.sum + " " + node.right.sum);
			update(node.left, a, (a + b) / 2, L, R, value);
			update(node.right, 1 + (a + b) / 2, b, L, R, value);
			node.sum = node.left.sum + node.right.sum;
		}

		long answer(Node node, int a, int b, int L, int R) {
			// System.out.println(node.lazy);
			c++;
			if (a > b || a > R || b < L) {
				return 0;
			}
			if (node.lazy != 0) {
				node.sum += (node.lazy * (b - a + 1));
				if (a != b) {
					node.left.lazy += node.lazy;
					node.right.lazy += node.lazy;
				}
				node.lazy = 0;
			}
			// System.out.println(a+" "+b+" "+node.sum+" "+node.left.sum+" "+node.right.sum);
			if (a >= L && b <= R)
				return node.sum;
			long sumL = answer(node.left, a, (a + b) / 2, L, R);
			long sumR = answer(node.right, 1 + (a + b) / 2, b, L, R);
			long sum = sumL + sumR;
			return sum;
		}
	}
}