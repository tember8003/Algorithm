#include <queue> 
#include <iostream>
#include <functional>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    priority_queue<int,vector<int>,greater<int>> q;
    int n,x;
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>x;
        if(x==0){
            if(!q.empty()){
                cout << q.top() <<'\n';
                q.pop();
            }
            else{
                cout << 0 <<'\n';
            }
        }
        else{
            q.push(x);
        }
    }

}
