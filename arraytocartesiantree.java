import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
class arraytocartesiantree {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		int N = reader.readInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = reader.readInt();
		CartesianTree ct = new CartesianTree(arr);
		ct.inorder();
		out.println();
		out.close();
	}
	static final class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read(buf);
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public final int readInt() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			boolean negative = false;
			if (c == '-') {
				negative = true;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return negative ? -res : res;
		}

		public final long readLong() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			boolean negative = false;
			if (c == '-') {
				negative = true;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return negative ? -res : res;
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}
}

class CTNode {
	CTNode left, right;
	int value;

	public CTNode() {
		left = null;
		right = null;
		value = 0;
	}
}

class CartesianTree {
	private CTNode root;

	public CartesianTree(int[] data) {
		root = build(data);
	}

	public CTNode build(int[] data) {
		if (data == null || data.length == 0)
			return null;
		return build(data, 0, data.length - 1);
	}

	private CTNode build(int[] data, int start, int end) {
		if (end < start)
			return null;
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i = start; i <= end; i++) {
			if (data[i] < min) {
				min = data[i];
				minIndex = i;
			}
		}
		CTNode node = new CTNode();
		node.value = min;
		node.left = build(data, start, minIndex - 1);
		node.right = build(data, minIndex + 1, end);
		return node;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int countNodes() {
		return countNodes(root);
	}

	private int countNodes(CTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(CTNode r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.value + " ");
			inorder(r.right);
		}
	}
}