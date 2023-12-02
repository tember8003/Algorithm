#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <cmath>
using namespace std;
//강의 참고했는데 이해가 잘 안됨.
int solution(vector<string> strs, string t)
{
    set<string> str_set(strs.begin(), strs.end());
    const int INF= 987654321;
    int len=t.length();
    int answer = 0;
    vector<int> dp(20002,INF);
    dp[len]=0;
    
    for(int i=len-1; i>=0; --i){
        string temp="";
        for(int j=0; i+j<len && j<5; ++j){
            temp += t[i+j];
            if(str_set.find(temp)!= str_set.end() && dp[i+j+1] !=INF){
                dp[i]=min(dp[i],dp[i+j+1]+1);
            }
        }
    }
    if(dp[0]==INF){
        answer=-1;
    }
    else{
        answer=dp[0];
    }
    return answer;
}