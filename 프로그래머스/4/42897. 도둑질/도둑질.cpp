#include <string>
#include <vector>
#include <cmath>

using namespace std;
long long dp1[1000001];
long long dp2[1000001];
int solution(vector<int> money) {
    int n= money.size()-1;
    dp1[0]=money[0];
    dp1[1]=money[0];
    for(int i=2; i<n; i++){
        dp1[i]=max(dp1[i-2]+money[i],dp1[i-1]);
    }
    dp2[0]=0;
    dp2[1]=money[1];
    for(int i=2; i<=n; i++){
        dp2[i]=max(dp2[i-2]+money[i],dp2[i-1]);
    }
    int answer=max(dp1[n-1],dp2[n]);
    return answer;
}