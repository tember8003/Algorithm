import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		String C = st.nextToken();
		
		BigInteger int_a = new BigInteger(A);
		BigInteger int_b = new BigInteger(B);
		BigInteger int_c = new BigInteger(C);
		
		System.out.println(int_a.add(int_b).add(int_c));
	}
}
