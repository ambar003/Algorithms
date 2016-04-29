import java.io.*;
import java.util.*;
class kthsmallest {
	static int temp;
	public static void main(String[] args) throws NumberFormatException,IOException {
		int i;
		List<Character> ar1 = new ArrayList<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int q = Integer.parseInt(str[1]);
		String s = br.readLine();
		for (i = 0; i < n; i++) {
			ar1.add(s.charAt(i));
		}
		while (q-- > 0) {
			Integer[] ch = (Integer[]) ar1.toArray();
			str = br.readLine().split(" ");
			int l = Integer.parseInt(str[0]);
			int r = Integer.parseInt(str[1]);
			int k = Integer.parseInt(str[2]);
			List<Character> ar2 = ar1.subList(l - 1, r);
			Collections.sort(ar2);
			if (k <= ar2.size()) {
				/*
				 * int[] arr=new int[ar2.size()];
				 * 
				 * for(i=0;i<ar2.size();i++){ arr[i]=ar2.get(i); } char
				 * ch=(char)test(arr,0,arr.length-1,k);
				 */
				System.out.println(ar2.get(k - 1));
				System.out.println(ar2);
			} else {
				System.out.println("Out of range");
			}
		}
	}

	static int partition(int arr[], int l, int r) {
		int x = arr[r], i = l;
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
		return i;
	}
	static int test(int arr[], int l, int r, int k) {
		int pos = 0;
		if (k > 0 && k <= r - l + 1) {
			pos = partition(arr, l, r);
			if (pos - l == k - 1)
				return arr[pos];
			if (pos - l > k - 1)
				return test(arr, l, pos - 1, k);
			return test(arr, pos + 1, r, k - pos + l - 1);
		}
		return k;
	}
}