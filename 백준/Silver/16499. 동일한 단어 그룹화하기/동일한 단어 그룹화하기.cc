#include <iostream>
#include <algorithm>
#include <string>
#include <map>

using namespace std;

int main()
{
    cin.tie(NULL); cout.tie(NULL);
    string s;
    map<string,int> map;
    int answer=0;
    int n;
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>s;
        sort(s.begin(),s.end());
        map[s]++;
    }
    for(auto key:map){
        answer++;
    }
    cout<<answer<<"\n";
    return 0;
}
