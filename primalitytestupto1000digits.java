import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
class primalitytestupto1000digits {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        boolean b=new BigInteger(in.next()).isProbablePrime(10);
        out.println(b ? "PRIME":"COMPOSITE");
        out.close();
	}
}
