import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
class mostpopularelementinarray {
	 public static void main(String[] args) throws IOException {
		 InputReader reader = new InputReader(System.in);
		 PrintWriter out = new PrintWriter(System.out);
	        int T = reader.readInt();
	        for (int t=0; t<T; t++) {
	            int N = reader.readInt();
	            long[] A = new long[N+1];
	            for (int n=0; n<N; n++) {
	                A[n] = reader.readLong();
	            }
	            int k=(int)N;
	            out.println(maxRepeating(A,N,k));
// this is use of sorting without changing elements value
	            A[N] = Integer.MAX_VALUE;
	            Arrays.sort(A);
	            int maxCount = 0;
	            int maxValue = 0;
	            int count = 0;
	            int value = 0;
	            for (int n=0; n<N+1; n++) {
	                if (A[n] == value) {
	                    count++;
	                } else {
	                    if (maxCount < count) {
	                        maxCount = count;
	                        maxValue = value;
	                    }
	                    count = 1;
	                    value = (int) A[n];
	                }
	            }
	            out.println(maxValue+" "+maxCount);
	            out.close();
	        }
	    }
	 static int maxRepeating(long[] arr, int n, int k)
	 {
	     // Iterate though input array, for every element
	     // arr[i], increment arr[arr[i]%k] by k
	     for (int i = 0; i< n; i++)
	         arr[(int) (arr[i]%k)] += k;
	  
	     // Find index of the maximum repeating element
	     int max = (int) arr[0], result = 0;
	     for (int i = 1; i < n; i++)
	     {
	         if (arr[i] > max)
	         {
	             max = (int) arr[i];
	             result = i;
	         }
	     }
	     /* Uncomment this code to get the original array back
	        for (int i = 0; i< n; i++)
	           arr[i] = arr[i]%k; */
	  
	     // Return index of the maximum element
	     return result;
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
