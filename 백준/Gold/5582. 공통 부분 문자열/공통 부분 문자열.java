import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        int[][] dp = new int[str2Arr.length+1][str1Arr.length+1];
        int result = 0;
        for(int i=1; i<=str2Arr.length; i++){
            char c = str2Arr[i-1];
            for(int j=1; j<=str1Arr.length; j++){
                if(c == str1Arr[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j]=0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);

    }
}
