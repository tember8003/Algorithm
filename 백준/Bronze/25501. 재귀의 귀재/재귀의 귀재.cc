#include <iostream>
#include <cstring>

using namespace std;

int recursion(const char* s, int l, int r, int &cnt) {
    cnt++;
    if (l >= r) return 1;
    if (s[l] != s[r]) return 0;
    return recursion(s, l + 1, r - 1, cnt);
}

int isPalindrome(const char* s, int &cnt) {
    return recursion(s, 0, strlen(s) - 1, cnt);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    while (n--) {
        string str;
        cin >> str;
        int cnt = 0;
        cout << isPalindrome(str.c_str(), cnt) << " " << cnt << "\n";
    }

    return 0;
}
