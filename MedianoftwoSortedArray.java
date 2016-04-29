import java.util.Arrays;

public class MedianoftwoSortedArray {
	public static void main(String[] args) {
		int ar1[] = {1, 12, 15, 26, 38};
		int ar2[] = {2, 13, 17, 30, 45};
		System.out.println(getMedianDivideAndConquer(ar1, ar2, 4));
	}

	static int getMedianDivideAndConquer(int[] ar1, int[] ar2, int n) {
		int m1, m2;
		if (n <= 0) {
			return -1;
		}
		if (n == 1) {
			return (ar1[0] + ar2[0]) / 2;
		}
		if (n == 2) {
			return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;
		}
		m1 = median(ar1, n);
		m2 = median(ar2, n);
		if (m1 == m2) {
			return m1;
		} else if (m1 < m2) {
			if (n % 2 == 0) {
				ar1 = Arrays.copyOfRange(ar1, n / 2 , n+1);
				ar2 = Arrays.copyOfRange(ar2, 0,n/2+1);
				System.out.println(ar1.length+" "+ar2.length);
//				System.out.print(Arrays.toString(ar1)+" ");
//				System.out.println(Arrays.toString(ar2));
				return getMedianDivideAndConquer(ar1, ar2, n - n / 2 + 1);
			} else {
				ar1 = Arrays.copyOfRange(ar1, n / 2, n+1);
				ar2 = Arrays.copyOfRange(ar2, 0,n/2+1);
				System.out.println(ar1.length+" "+ar2.length);
//				System.out.print(Arrays.toString(ar1)+" ");
//				System.out.println(Arrays.toString(ar2));
				return getMedianDivideAndConquer(ar1, ar2, n - n / 2);
			}
		} else {
			if (n % 2 == 0) {
				ar2 = Arrays.copyOfRange(ar2, n / 2, n+1);
				ar1 = Arrays.copyOfRange(ar1, 0,n/2+1);
				System.out.println(ar1.length+" "+ar2.length);
//				System.out.print(Arrays.toString(ar1)+" ");
//				System.out.println(Arrays.toString(ar2));
				return getMedianDivideAndConquer(ar2, ar1, n - n / 2 + 1);
			} else {
				ar1 = Arrays.copyOfRange(ar1, 0,n/2+1);
				ar2 = Arrays.copyOfRange(ar2, n / 2,n);
				System.out.println(ar1.length+" "+ar2.length);
//				System.out.print(Arrays.toString(ar1)+" ");
//				System.out.println(Arrays.toString(ar2));
				return getMedianDivideAndConquer(ar2, ar1, n - n / 2);
			}
		}
	}

	static void getMedianBinarySearch(int[] ar1, int[] ar2, int n) {

	}

	static int median(int[] ar, int n) {
		if (n % 2 == 0) {
			return (ar[n / 2] + ar[(n / 2) - 1]) / 2;
		} else {
			return ar[n / 2];
		}
	}
}
