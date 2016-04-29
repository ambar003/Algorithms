import java.util.Arrays;

class StringHashing {
	static long b = 100000007;
	static long mod = 1000000009;
	static long[] pre_hash;
	static long[] suf_hash;
	static long[] invmod;

	public static void main(String[] args) {
		String s = "Amadamb";
		pre_hash = new long[s.length()];
		suf_hash = new long[s.length()];
		invmod = new long[s.length()];
		pre_hash(s);
		suf_hash(s);
		System.out.println(getHash(s));
		System.out.println(Arrays.toString(pre_hash));
		System.out.println(Arrays.toString(suf_hash));
		System.out.println(getSubHash(1, 5)==getSubRHash(1, 5));
	}

	static long getHash(String s) {
		long h = 0;
		int length = s.length();
		for (int i = length - 1; i >= 0; i--) {
			h *= b;
			h += (s.charAt(i) - 'a');
			h %= mod;
		}
		return h;
	}

	/*
	 * prefix hash table for a given string
	 */
	static void pre_hash(String s) {
		pre_hash[0] = s.charAt(0);
		int len = s.length();
		for (int i = 1; i < len; i++) {
			pre_hash[i] = (pre_hash[i - 1] + (s.charAt(i) * b) % mod) % mod;
		}
	}

	/*
	 * suffix hash table for a given string
	 */
	static void suf_hash(String s) {
		int len = s.length();
		suf_hash[len - 1] = s.charAt(len - 1);
		for (int i = len - 2; i >= 0; i--) {
			suf_hash[i] = (suf_hash[i + 1] + (s.charAt(i) * b) % mod) % mod;
		}
	}

	/*
	 * forward hash of string S[i..j] i, j: range for which hash is calculated
	 */
	static long getSubHash(int i, int j) {
		long jh = pre_hash[j];
		long ih = i > 0 ? pre_hash[i - 1] : 0;
		long subhash = ((jh + mod - ih) * (invmod[i])) % mod;
		return subhash;
	}

	/*
	 * reverse hash of string S[i..j] i, j: range for which hash is calculated
	 */
	static long getSubRHash(int i, int j) {
		long ih = suf_hash[i];
		int n = suf_hash.length;
		long jh = j < n - 1 ? suf_hash[j + 1] : 0;
		long subhash = ((ih + mod - jh) * (invmod[n - 1 - j])) % mod;
		return subhash;
	}

	static void inversemod() {
		invmod[0] = 1;
		int len = invmod.length;
		long inverse = modInverse(b, mod);
		invmod[1] = inverse;
		for (int i = 2; i < len; i++) {
			invmod[i] = (invmod[i - 1] * inverse) % mod;
		}
	}

	static long modPow(long a, long x, long p) {
		// calculates a^x mod p in logarithmic time.
		long res = 1;
		while (x > 0) {
			if (x % 2 != 0) {
				res = (res * a) % p;
			}
			a = (a * a) % p;
			x /= 2;
		}
		return res % p;
	}

	static long modInverse(long a, long p) {
		// calculates the modular multiplicative of a mod m.
		// (assuming p is prime).
		return modPow(a, p - 2, p);
	}
}
