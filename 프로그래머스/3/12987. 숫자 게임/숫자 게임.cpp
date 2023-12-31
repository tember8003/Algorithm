#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer=0;
    priority_queue<int,vector<int>,greater<int>> a_temp;
    priority_queue<int,vector<int>,greater<int>> b_temp;
    for(int i=0; i<A.size(); i++){
        a_temp.push(A[i]);
        b_temp.push(B[i]);
    }
    while(!b_temp.empty()){
        int num_a = a_temp.top();
        a_temp.pop();
        while(!b_temp.empty()){
            int num_b=b_temp.top();
            b_temp.pop();
            if(num_a < num_b){
                answer++;
                break;
            }
        }
    }
    return answer;
}