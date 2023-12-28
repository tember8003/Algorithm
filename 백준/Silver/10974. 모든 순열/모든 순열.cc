#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
using namespace std;
vector<int> v;
int main()
{
    int n;
    cin>>n;
    for(int i=1; i<=n; i++){
        v.push_back(i);
    }
    do{
        for(auto it=v.begin();it!=v.end();++it){
            cout<<*it<<" ";
        }
        cout<<"\n";
    }while(next_permutation(v.begin(),v.end()));
    return 0;
}
