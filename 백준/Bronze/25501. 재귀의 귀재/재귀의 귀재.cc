#include <iostream>
#include <sstream>
#include <cstring>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>
using namespace std;

int cnt = 0;

int recursion(const char* s, int l, int r) {
	cnt++;
	if (l >= r)
		return 1;
	else if (s[l] != s[r])
		return 0;
	else
		return recursion(s, l + 1, r - 1);
}

int isPalindrome(const char* s) {
	return recursion(s, 0, strlen(s) - 1);
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	string str;
	for (int i = 0; i < n; i++) {
		cnt = 0;
		cin >> str;
		cout << isPalindrome(str.c_str()) << " " << cnt << "\n";
	}
}