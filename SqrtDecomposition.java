import java.util.Arrays;
class SqrtDecomposition {
	static int len;
	static int[] sqrtSums;

	public static void main(String[] args) {
		int[] arr = { 3, 5, 7, 2, 4, };
		sqrtDecomposition(arr);
		int sum = 0;
//		System.out.println(getSum(arr, 1, 8, len) + " " + count);
		for (int i = 0; i < arr.length; i++)
			for (int j = i; j < arr.length; j++) {
				// count=0;
				System.out.println(i + " " + j + " " + getSum(arr, i, j, len) + " " + count);
				sum += Math.abs(i - j) + 1;
			}
		System.out.println(count + " " + sum);
	}

	private static void sqrtDecomposition(int[] arr) {
		len = (int) Math.ceil(Math.sqrt(arr.length));
		System.out.println(len);
		sqrtSums = new int[len];
		int t = 0;
		for (int i = 0; i < arr.length; i++)
			sqrtSums[i / len] += arr[i];
//		System.out.println(Arrays.toString(sqrtSums));
	}

	static int count = 0;

	private static int getSum(int[] arr, int l, int r, int len) {
		int sum = 0;
		int i = l;
		// System.out.println(i);
		while (i % len != 0 && i <= r) {
			sum += arr[i];
			i++;
			count++;
		}
		// System.out.println(i);
		while (i + len <= (r + 1)) {
			sum += sqrtSums[i / len];
			i += len;
			count++;
		}
		// System.out.println(i);
		while (i <= r) {
			sum += arr[i];
			i++;
			count++;
		}
		// System.out.println(i);
		return sum;
	}
}