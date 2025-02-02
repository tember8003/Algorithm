#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int strplus(const string &a) {
    int sum = 0;
    for (char ch : a) {
        if (isdigit(ch)) { //주어진 문자가 0~9(숫자)인지 확인하는 함수
            sum += ch - '0';
        }
    }
    return sum;
}

bool compare(const string &a, const string &b) {
    if (a.length() != b.length()) 
        return a.length() < b.length();
    
    int a_plus = strplus(a);
    int b_plus = strplus(b);

    if (a_plus != b_plus) 
        return a_plus < b_plus;

    return a < b;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    
    vector<string> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end(), compare);

    for (int i = 0; i < n; i++) {
        cout << arr[i] << "\n";
    }

    return 0;
}
