import java.util.Arrays;

public class ZAlgorithm {
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(Zalgorithm("abab$baba")));
	}
	static int[] Zalgorithm(String s) {
		int L = 0, R = 0;
		int n = s.length();
		int[] Z = new int[n];
		for (int i = 1; i < n; i++) {
			if (i > R) {
				L = R = i;
				while (R < n && s.charAt(R - L) == s.charAt(R))
					R++;
				Z[i] = R - L;
				R--;
			} else {
				int k = i - L;
//				System.out.println(k);
				if (Z[k] < R - i + 1)
					Z[i] = Z[k];
				else {
					L=i;
					while (R < n && s.charAt(R - L) == s.charAt(R))
						R++;
					Z[i] = R - L;
					R--;
				}
			}
//			System.out.println(i+" "+R+" "+L);
		}
		return Z;
	}
}