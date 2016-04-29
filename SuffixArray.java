import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {
	static final int MAXN = 5001;
	static final int MAXLOG = 15;
	static char[] A;
    static int[] lcp;
	// suffarray stores the index of the suffixes .
    // lcp stores the longest common prefix of consecutive suffixes. 
	public static void main(String[] args) {
		String s = "abacdbabcda";
		int[] suffarray = SA(s.toCharArray());
		lcp=new int[s.length()]; 
		lcp[0]=0;
        for(int i=1;i<s.length();i++)
        	lcp[i]=lcp(suffarray[i],suffarray[i-1]);
        System.out.println(Arrays.toString(suffarray));
        System.out.println(Arrays.toString(lcp));
	}
	static int lcp(int x, int y) {
		int k, ret = 0;
		if (x == y)
			return N - x;
		for (k = stp - 1; k >= 0 && x < N && y < N; k--)
			if (P[k][x] == P[k][y]) {
				x += 1 << k;
				y += 1 << k;
				ret += 1 << k;
			}
		return ret;
	}
	static int[][] P;
	static Entry[] L;
	static int stp, N;

	static int[] SA(char[] A) {
		L = new Entry[MAXN];
		int i;
		N = A.length;
		for (i = 0; i < L.length; i++)
			L[i] = new Entry();
		P = new int[MAXLOG][MAXN];
		for (i = 0; i < N; i++)
			P[0][i] = A[i] - 'a';
		int cnt;
		for (stp = 1, cnt = 1; (cnt >> 1) < N; stp++, cnt <<= 1) {
			for (i = 0; i < N; i++) {
				L[i].nr0 = P[stp - 1][i];
				L[i].nr1 = i + cnt < N ? P[stp - 1][i + cnt] : -1;
				L[i].p = i;
			}
			Arrays.sort(L, 0, N, comparator);
			for (i = 0; i < N; i++) {
				P[stp][L[i].p] = i > 0 && L[i].nr0 == L[i - 1].nr0
						&& L[i].nr1 == L[i - 1].nr1 ? P[stp][L[i - 1].p] : i;
			}
		}
		int[] B= new int[N];
		for (i = 0; i < N; i++) {
			B[P[stp - 1][i]] = i;
		}
		return B;
	}

	static Comparator<Entry> comparator = new Comparator<Entry>() {
		public int compare(Entry a, Entry b) {
			return a.nr0 == b.nr0 ? (a.nr1 - b.nr1) : (a.nr0 - b.nr0);
		}
	};

	static class Entry {
		int nr0, nr1, p;
	}
}