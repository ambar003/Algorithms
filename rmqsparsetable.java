import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
//Sparse table. Solves static RMQ problem (without element changes).
//O(NlogN) on precalculation, O(1) on query.
class rmqsparsetable {
	static final int MAXN = 2 * 105000;
	static final int MAXLOG = 20;
	static long a[] = new long[MAXN];
	static long table[][] = new long[MAXLOG][MAXN];
	static long numlog[] = new long[MAXN];
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		long startTime = System.currentTimeMillis();
		long n = reader.readLong();
		a = new long[(int) n + 1];
		long i;
		for (i = 1; i <= n; i++)
			a[(int) i] = reader.readLong();
		buildTable(n);
		long m = reader.readLong();
		long x = reader.readLong();
		long y = reader.readLong();
		long sum = 0;
		long min = 0, max = 0;
		min = min(x, y);
		max = max(x, y);
		sum += getMax(min + 1, max + 1);
		for (i = 1; i < m; i++) {
			long a = (x + 7) % (n - 1);
			long b = (y + 11) % n;
			x = a;
			y = b;
			min = min(a, b);
			max = max(a, b);
			sum += getMax(min + 1, max + 1);
		}
		out.println(sum);
		long endTime = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 out.println(totalTime);
		 out.close();
	}
    static long max(long a,long b){
    	if(a>b)
    		return a;
    	else
    	return b;
    	
    }
    static long min(long a,long b){
    	if(a<b)
    		return a;
    	else
    	return b;
    	
    }
	private static void buildTable(long n) {
		numlog[1] = 0;
		for (int i = 2; i <= n; i++)
			numlog[i] = numlog[i / 2] + 1;
		for (int i = 0; i <= numlog[(int) n]; i++) {
			int curlen = 1 << i;
			for (int j = 1; j <= n; j++) {
				if (i == 0) {
					table[i][j] = a[j];
					continue;
				}
				table[i][j] = max(table[i - 1][j], table[i - 1][j + curlen/ 2]);
			}
		}
	}

	private static long getMax(long l, long r) {
		long curlog = numlog[(int) (r - l + 1)];
		return max(table[(int) curlog][(int) l],table[(int) curlog][(int) r - (1 << curlog) + 1]);
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
