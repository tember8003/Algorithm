#include <iostream>

using namespace std;

int main()
{
    int N;
    cin >> N;
    string result="";
    
    for(int i=0; i<N/4; i++){
        result+="long ";
    }
    
    result+="int";
    
    cout<<result;
    return 0;
}