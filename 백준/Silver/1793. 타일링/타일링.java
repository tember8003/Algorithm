import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	//dp + 큰 수 다루기(BigInteger)
	static BigInteger[] dp = new BigInteger[251];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		calculate();
		
		String input;
		while((input = br.readLine())!=null) {
			int n = Integer.parseInt(input);
			System.out.println(dp[n]);
		}
	}
	
	public static void calculate() {
		dp[0] = new BigInteger("1"); dp[1]= new BigInteger("1"); dp[2]= new BigInteger("3");
		for(int i=3; i<=250; i++) {
			BigInteger two = new BigInteger("2");
			BigInteger addNum = dp[i-1].add(dp[i-2].multiply(two));
			
			dp[i] = addNum;
		}
	}
}
