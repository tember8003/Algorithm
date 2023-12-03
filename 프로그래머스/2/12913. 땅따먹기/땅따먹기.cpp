#include <iostream>
#include <vector>
using namespace std;
#define INF 987654321;
long long dp[100001][4];
int solution(vector<vector<int> > land)
{
    int answer = 0;
    for(int i=0; i<land.size()-1; i++){
        land[i+1][0]+=max(land[i][1],max(land[i][2],land[i][3]));
        land[i+1][1]+=max(land[i][0],max(land[i][2],land[i][3]));
        land[i+1][2]+=max(land[i][0],max(land[i][1],land[i][3]));
        land[i+1][3]+=max(land[i][0],max(land[i][1],land[i][2]));
    }
    for(int i=0; i<4; i++){
        if(land[land.size()-1][i] > answer){
            answer=land[land.size()-1][i];
        }
    }
    return answer;
}