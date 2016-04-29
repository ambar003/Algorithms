import java.util.Arrays;

class BinaryVariant {
	public static void main(String[] args) {
		int arr[] = { 3, 5, 7, 11, 13, 17, 19 };
		int l = lowerbound(arr, 7, 6);
		System.out.println(l);
		System.out.println(Arrays.binarySearch(arr,2)+1);
		int k = upperbound(arr, 7, 6);
		System.out.println(k);
		int u = k - l;
		// int u = upperbound(arr, 6, 5) - lowerbound(arr, 6, 5);
		System.out.println(l + " " + k + " " + u);
	}

	static int lowerbound(int[] a, int n, int targetnum) {
		int first = 0, last = n - 1, mid;
		while (first < last) {
			mid = first + (last - first) / 2;
			if (a[mid] == targetnum) {
				last = mid;
			} else if (a[mid] > targetnum) {
				last = mid - 1;
			} else if (a[mid] < targetnum) {
				first = mid + 1;
			}
		}
		if (a[first] >= targetnum)
			return first;
		return first + 1;
	}

	static int upperbound(int[] a, int n, int targetnum) {
		int first = 0, last = n - 1, mid;
		while (first < last) {
			mid = first + (last - first) / 2;
			if (a[mid] == targetnum) {
				first = mid + 1;
			} else if (a[mid] > targetnum) {
				last = mid - 1;
			} else if (a[mid] < targetnum) {
				first = mid + 1;
			}
		}
		 if (last >= 0 && a[last] > targetnum)
		 return last;
		return last + 1;
	}
}