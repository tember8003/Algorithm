class Solution {
    static int[] dp = new int[60002];
    public int solution(int n) {
        int answer = 0;
        dp[1]=1; dp[2]=2; dp[3]=3;
        if(n<=3){
            answer=dp[n];
        }
        else{
            for(int i=4; i<=n; i++){
                dp[i]=(dp[i-1]+dp[i-2])%1000000007;
            }
            answer=dp[n];
        }
        return answer;
    }
}