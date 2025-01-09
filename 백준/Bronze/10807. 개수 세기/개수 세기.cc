#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int N,v;
    int result=0;
    vector<int> vec(N+1);
    cin >> N;
    
    for(int i=0; i<N; i++){
        cin>>vec[i];
    }
    
    cin>>v;
    for(int i=0; i<N; i++){
        if(vec[i]==v){
            result++;
        }
    }
    
    cout<<result;
    return 0;
}