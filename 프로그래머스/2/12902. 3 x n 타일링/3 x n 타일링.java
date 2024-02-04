class Solution {
    static long[] dp;
    public long solution(int n) {
        int num=1000000007;
        dp=new long[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=3;
        dp[3]=0;
        dp[4]=11;
        if(n<=4){
            return dp[n];
        }
        else{
            for(int i=5; i<=n; i++){
                if(i%2==0){
                    dp[i]=(((dp[i-2]*4)%num) - (dp[i-4]%num)+num)%num;
                }
                else{
                    dp[i]=0;
                }
            }
            return dp[n];
        }
        
    }
}