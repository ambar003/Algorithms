import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//                                      Fermat Little Theorem:-
//If a is an integer, p is a prime number and a is not divisible by p, then a^p-1(mod p)==1.
//                                        a^p mod p==a
//                                        a^m-2 mod p==1/a or a^-1
public class Fermattheorem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int mod = Integer.parseInt(br.readLine());
			System.out.println(findMMIfermat(n,mod));
		}
	}
	
	public static long findMMIfermat(long n, long M) {
		return fastpow(n, M - 2, M);
	}

	private static long fastpow(long base, long pow, long m) {
		long result = 1;
		while (pow > 0) {
			if (pow % 2 == 1)
				result = (result * base) % m;
			base = (base * base) % m;
			pow /= 2;
		}
		return result;
	}
}