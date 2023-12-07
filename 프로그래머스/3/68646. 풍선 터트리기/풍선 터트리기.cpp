#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> a) {
    int answer = a.size();
    stack<int> stacks;
    for(int i=0; i<a.size(); i++){
        while(!stacks.empty() && a[i] < stacks.top()){
            stacks.pop();
            if(!stacks.empty()){
                answer--;
            }
        }
        stacks.push(a[i]);
    }
    
    return answer;
}