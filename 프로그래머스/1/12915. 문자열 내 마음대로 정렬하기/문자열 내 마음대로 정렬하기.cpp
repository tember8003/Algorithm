#include <algorithm>
#include <string>
#include <vector>

using namespace std;
int temp;
bool cmp(string a,string b){
    if(a[temp]==b[temp]){
        return a<b;
    }
    else{
        return a[temp]<b[temp];
    }
}
vector<string> solution(vector<string> strings, int n) {
    temp=n;
    sort(strings.begin(),strings.end(),cmp);
    
    return strings;
}