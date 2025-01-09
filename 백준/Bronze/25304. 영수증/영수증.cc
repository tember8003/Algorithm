#include <iostream>

using namespace std;

int main()
{
    int X,N,a,b;
    cin >> X;
    cin >> N;
    for(int i=0; i<N; i++){
        cin>>a>>b;
        X -= a*b;
    }
    
    if(X==0){
        cout<<"Yes";
    }
    else{
        cout<<"No";
    }

    return 0;
}