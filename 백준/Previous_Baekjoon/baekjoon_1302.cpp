//정렬,맵
//제목:베스트셀러
#include <bits/stdc++.h>
using namespace std;
map <string,int> m;
int n, cnt ;
int main(){
    cin >> n;
    while(n--){
        string bookName;
        cin >> bookName;
        m[bookName]++;
    }
    for(auto p : m) cnt = max(cnt, p.second);
    for(auto p : m){
        if(p.second == cnt){
            cout << p.first; 
            return 0;
        }
    }
    
}
