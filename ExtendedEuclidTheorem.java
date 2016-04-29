public class ExtendedEuclidTheorem {
	static int d, x, y;
// GCD(A,B) has a property that it can always be represented in the form of an equation Ax+By=GCD(A,B)
// d=gcd of A and B.
// x=Coefficient of x in equation Ax+By=GCD(A,B)
// Time Complexity:-O(Log(max(A,B)))	
	public static void main(String[] args) {
     extendedEuclid(3,2);
     System.out.println(d);
     System.out.println(x+" "+y);
	}

	static void extendedEuclid(int A, int B) {
		if (B == 0) {
			d = A;
			x = 1;
			y = 0;
		} else {
			System.out.println(A+" "+B);
			extendedEuclid(B, A % B);
			int temp = x;
			x = y;
			y = temp - (A / B) * y;
			System.out.println(x+" "+y);
		}
	}
}
