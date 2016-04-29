import java.io.IOException;
import java.math.BigInteger;
// boolean array contains whether a no is prime or not.
// it value is true then no is not prime otherwise prime.
// primes array hold prime no.
// Time Complexity:-O(LogLogN)
public class Sieve {
	public static void main(String[] args) throws NumberFormatException,IOException {
		sieve(10000);
	}
	static long primes[] = new long[10001];
	static boolean arr[] = new boolean[10001];
	public static void sieve(int n) {
		if (n >= 2) {
			long i, j = 0;
			for (i = 2; i < n; i++) {
				if (arr[(int) i] == false) {
					primes[(int) j] = i;
					j++;
					markmulti(arr, i, n);
				}
			}
			System.out.println(j);
		}
	}
	private static void markmulti(boolean[] arr, long l, int n) {
		int i = 2, num;
		while ((num = (int) (i * l)) <= n) {
			arr[num] = true;
			i++;
		}
	}
}