import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static int[] num;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        num = new int[n+1];
        num[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());
            if(gender == 1){ //남자
                int count = switchNum;
                while(switchNum <= n){
                    num[switchNum] = num[switchNum] == 0 ? 1 : 0; //스위치 상태가 0이면 1로, 1이면 0 으로
                    switchNum += count;
                }
            }
            else{ //여자
                int range = Math.min(switchNum - 1, n - switchNum);
                int count = 0;

                for(int j = 0; j<=range; j++){
                    if(num[switchNum-j] == num[switchNum+j]){
                        count = j;
                    }
                    else{
                        break;
                    }
                }

                for(int j = switchNum - count; j <= switchNum + count; j++){
                    num[j] = num[j] == 0 ? 1 : 0;
                }
            }
        }

        int count = 0;
        for(int i=1; i<=n; i++){
            if(count >= 20){
                count = 0;
                sb.append("\n");
            }
            sb.append(num[i] + " ");
            count++;
        }

        System.out.println(sb.toString());
    }
}