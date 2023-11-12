#include <string>
#include <vector>

using namespace std;

int dp[101][101];
int solution(int m, int n, vector<vector<int>> puddles) {
    dp[1][1]=1;
    for(int i=0; i<puddles.size(); i++){
        dp[puddles[i][1]][puddles[i][0]]=-1;
    }
    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++){
            int sol1=0;
            int sol2=0;
            if(dp[i][j]==-1){
                continue;
            }
            if(dp[i-1][j]!=-1){
                sol1=dp[i-1][j];
            }
            if(dp[i][j-1]!=-1){
                sol2=dp[i][j-1];
            }
            dp[i][j]+=(sol1+sol2)%1000000007;
            
        }
    }
    int answer = dp[n][m];
    return answer;
}