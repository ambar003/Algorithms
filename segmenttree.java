public class segmenttree {
	static long[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20 };
	static int c = 0;

	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		Node node = new Node(0, A.length - 1);
		node.update(node, 0, A.length - 1, 0, 19, 10);
		System.out.println(node.answer(0, 9));
		System.out.println(c);
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}

	static class Node {
		int from, to;
		long sum = 0;
		Node left;
		Node right;
		long multipication = 1;

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
			c++;
			if (a > b || a > R || b < L) {
				return;
			}
			if (a == b) {
				node.sum += value;
				return;
			}
			int mid = (a + b) / 2;
			update(node.left, a, mid, L, R, value);
			update(node.right, 1 + mid, b, L, R, value);
			node.sum = node.left.sum + node.right.sum;
		}

		long answer(int L, int R) {
			c++;
			if (L <= from && to <= R) {
				return sum;
			} else if (to < L || R < from) {
				return 0;
			} else {
				long sumL = left.answer(L, R);
				long sumR = right.answer(L, R);
				return (sumL + sumR);
			}
		}
	}
}