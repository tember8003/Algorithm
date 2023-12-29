#include <string>
#include <vector>
#include <cstdio>
#include <algorithm>
#include <queue>

using namespace std;

long long solution(int n, vector<int> works) {
    priority_queue<int,vector<int>,less<int>> q;
    for(int i=0; i<works.size(); i++){
        q.push(works[i]);
    }
    while(n>0){
        int temp=q.top();
        q.pop();
        temp--;
        q.push(temp);
        n--;
        if(q.top()==0){
            break;
        }
    }
    long long answer = 0;
    while(!q.empty()){
        answer+=q.top()*q.top();
        q.pop();
    }
    
    return answer;
}