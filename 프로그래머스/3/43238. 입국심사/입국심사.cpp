#include <string>
#include <vector>
#include <algorithm>
//https://0xd00d00.github.io/2021/06/29/programmers_entry_test.html 참고
using namespace std;

long long solution(int n, vector<int> times) {
    sort(times.begin(),times.end());
    long long answer = 0;
    long long left=1;
    long long right=n*(long long)times.back();
    
    while(left<=right){
        long long temp=0;
        long long mid=(left+right)/2;
        for(int i=0; i<times.size(); i++){
            temp+=(mid/(long long)times[i]);
        }
        if(temp>=n){
            right=mid-1;
            answer=mid;
        }
        else{
            left=mid+1;
        }
    }
    return answer;
}