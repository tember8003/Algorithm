#include <iostream>
#include <vector>
using namespace std;
#define INF 987654321;
long long dp[100001][4];
int solution(vector<vector<int> > land)
{
    int answer = 0;
    int d = land.size();
    for(int i=0; i<4; i++){
        dp[0][i]=land[0][i];
    }
    for(int i=1; i<d; i++){
        for(int j=0; j<4; j++){
            for(int k=0; k<4; k++){
                if(k!=j){
                    dp[i][j]=max(dp[i][j],dp[i-1][k]+land[i][j]);
                }
            }
        }
    }
    for(int i=0; i<4; i++){
        if(answer < dp[d-1][i]){
            answer=dp[d-1][i];
        }
    }
    return answer;
}