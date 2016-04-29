import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class PrimeFactorization {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine());
			System.out.println(sumofallfactors(n));
			int[] arr={2,3,5,7,11,13,17,19,23,29,31};
			long k=n;
			int count=0;
			int i=0;
			while(k>1){
				int a=arr[i];
				count=0;
				while(k%arr[i]==0){
					k/=arr[i];
					count++;
				}
				System.out.println(arr[i]+" "+count);
				i++;
			}
//				System.out.println(count);
//sum of all factors of n not including n itself
//			System.out.println(sumofallfactors(n));
// sum of all factors of n including n
//			System.out.println(sumofallfactors(n)+n);
		}
	}
	static long sumofallfactors(long n) {
		long maxD = (long) Math.sqrt(n);
		long sum = 0;
		int count=0;
		for (long i = 2; i <= maxD; i++) {
			if (n % i == 0) {
				sum += i;
				count++;
				System.out.print(i+" ");
				long d = (long) (n / i);
				if (d != i){
					sum += d;
					count++;
					System.out.print(d+" ");
				}
			}
		}
		System.out.println();
		System.out.println(count);
		return sum;
	}
}