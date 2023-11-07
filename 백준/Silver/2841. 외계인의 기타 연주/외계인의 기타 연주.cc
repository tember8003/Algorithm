#include <iostream>
#include <stack>

using namespace std;

int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    stack<int> stacks[8];
    int n,p; int line,num;
    int count=0;
    cin>>n>>p;
    
    for(int i=0; i<n; i++){
        cin>>line>>num;
        if(stacks[line].empty()){
            stacks[line].push(num);
            count++;
        }
        else if(stacks[line].top() < num){
            stacks[line].push(num);
            count++;
        }
        else if(stacks[line].top() > num){
            while(stacks[line].top() > num){
                stacks[line].pop();
                count++;
                if(stacks[line].empty()){
                    stacks[line].push(num);
                    count++;
                }
            }
            if(stacks[line].top() < num){
                stacks[line].push(num);
                count++;
            }
        }
    }
    cout <<count << "\n";
    

    return 0;
}
