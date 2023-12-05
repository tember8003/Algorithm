#include <iostream>
#include <vector>
using namespace std;
int dp1[100001];
int dp2[100001];

//알고리즘 문제풀이 강의 참고
//https://school.programmers.co.kr/learn/courses/18/lessons/930
int solution(vector<int> sticker)
{
    int n=sticker.size();
    dp1[0]=sticker[0];
    dp1[1]=dp1[0];
    if(n==1){
        return sticker[0];
    }
    for(int i=2; i<n-1; i++){
        dp1[i]=max(dp1[i-1],dp1[i-2]+sticker[i]);
    }
    dp2[0]=0;
    dp2[1]=sticker[1];
    for(int i=2; i<n; i++){
        dp2[i]=max(dp2[i-1],dp2[i-2]+sticker[i]);
    }
    return max(dp1[n-2],dp2[n-1]);
}