import java.util.*;
// This is Lucas theorem to calculate binomial coefficient.
// it is used when value of mod is prime and it is less than equal to 10^7.
public class binomialcoefficientmodprime {
	final static int MOD = 1009;
	static long[] factorial = new long[MOD + 1];
	static long[] inverse = new long[MOD + 1];
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		long f = 1, v = 1;
		factorial[0] = inverse[0] = 1;
		for (int i = 1; i <= MOD; i++) {
			f = (f * i) % MOD;
			factorial[i] = f;
			v = (v * modInverse(i)) % MOD;
			inverse[i] = v;
		}

		int t = in.nextInt();
		while (t-- > 0) {
			long n = in.nextLong();
			long k = in.nextLong();
			long res = 1;
			while (n > 0 && k > 0) {
				int n1 = (int) (n % MOD);
				int k1 = (int) (k % MOD);

				if (k1 > n1) {
					res = 0;
					break;
				}

				res = res * factorial[n1] % MOD;
				res = res * inverse[k1] % MOD;
				res = res * inverse[n1 - k1] % MOD;

				n /= MOD;
				k /= MOD;
			}
			System.out.println(res);
		}
	}

	static long modInverse(long i) {
		long pow = MOD - 2;
		long ret = 1;
		while (pow > 0) {
			if ((pow & 1) > 0)
				ret = ret * i % MOD;
			i = i * i % MOD;
			pow >>= 1;
		}
		return ret;
	}
}