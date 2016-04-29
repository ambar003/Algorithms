public class FenWickTree {
	static int[] dataAdd;
	static int[] dataMul;

	private static int[] ConstructBit(int[] data, int n) {
		int Bit[] = new int[n + 1];
		for (int i = 0; i < n; i++)
			update(Bit, n, i, data[i]);
		return Bit;
	}

	static void update(int[] data, int n, int at, int by) {
		at++;
		while (at <= data.length) {
			data[at] += by;
			at += at & (-at);
		}
	}

	static int query(int[] data, int n, int at) {
		int res = 0;
		at++;
		while (at > 0) {
			res += data[at];
			at -= at & (-at);
		}
		return res;
	}

	static void update(int[] data, int n, int left, int right, int by) {
		internalUpdate(data, left, by, -by * (left - 1));
		internalUpdate(data, right, -by, by * right);
	}

	private static void internalUpdate(int[] data, int at, int mul, int add) {
		at++;
		while (at <= dataMul.length) {
			dataMul[at] += mul;
			dataAdd[at] += add;
			at += at & (-at);
		}
	}

	static int query(int at) {
		int mul = 0;
		int add = 0;
		int start = at;
		at++;
		while (at > 0) {
			mul += dataMul[at];
			add += dataAdd[at];
			at -= at & (-at);
		}
		return mul * start + add;
	}

	public static void main(String[] args) {
		int[] data = { 5, 2, 4, 7, 9, 10 };
		int n = data.length;
		dataMul = new int[n + 1];
		dataAdd = ConstructBit(data, n);
		update(dataAdd, n, 2, 4, 1);
		update(dataAdd, n, 1, 4, 1);
		update(dataAdd, n, 2, 3, 1);
		update(dataAdd, n, 2, 5, 1);
		System.out.println(query(1));
	}
}