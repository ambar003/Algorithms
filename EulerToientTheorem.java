
//                                                      Euler theorem:-
//relatively prime i.e. gcd(a,b)==1
//                                 Euler's totient function phi(n) applied to a positive integer
// n is defined to be the number of positive integers less than or equal to n that are relatively prime to n.
// Let phi(n) be Euler's totient function. If a is an integer and m is a positive integer relatively prime to a,
// in other words If n is a positive integer, phi(n) is the number of integers in the range {1,2,3,.......,n} 
// which are relatively prime to n.Then a^phi (m)== 1 mod m.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class EulerToientTheorem {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		// int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(phi(n));
		}
		
	}

	public static int phi(int n) {
		int res = n;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				res -= res / i;
			}
		if (n > 1)
			res -= res / n;
		return res;
	}
}