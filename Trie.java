import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
class Trie {
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		trie root = new trie();
		int t = reader.readInt();
		boolean myflag = true;
		while (t-- > 0) {
			String str = reader.readString();
			myflag = myflag && isInsert(str, root);
		}
		if (myflag)
			out.println("non vulnerable");
		else
			out.println("vulnerable");
		out.close();
	}

	static boolean isInsert(String str, trie root) {
		trie node = root;
		boolean flag = false;
		int i;
		for (i = 0; i < str.length(); i++) {
			if ((node.child[str.charAt(i) - 'a']) == null) {
				flag = true;
				node.child[str.charAt(i) - 'a'] = new trie();
			}
			node = node.child[str.charAt(i) - 'a'];
			if (!flag && node.leaf==true)
				return false;
		}
		node.leaf=true;
		if (!flag)
			return false;
		return true;
	}

	static class trie {
		trie[] child;
		boolean leaf;

		trie() {
			leaf = false;
			child = new trie[26];
			Arrays.fill(child, null);
		}
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
			return (int) readLong();
		}

		public final long readLong() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
				if (c == -1)
					throw new IOException();
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

		public final int[] readIntArray(int size) throws IOException {
			int[] array = new int[size];
			for (int i = 0; i < size; i++) {
				array[i] = readInt();
			}
			return array;
		}

		public final long[] readLongArray(int size) throws IOException {
			long[] array = new long[size];
			for (int i = 0; i < size; i++) {
				array[i] = readLong();
			}
			return array;
		}

		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}
}