//dp문제
//제목: 전깃줄
#include <iostream>
#include <algorithm>
using namespace std;
struct Arr {
	int left;
	int right;
};
int n;
Arr arr[110];
int dp[110];

int max(int a, int b) {
	if (a > b) return a;
	return b;
}
bool Compare(Arr a, Arr b) {
	if (a.left < b.left) return true;
	return false;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int temp = 0;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i].left >> arr[i].right;
	}
	sort(arr + 1, arr + n+1, Compare);
	for (int i = 1; i <= n; i++) {
		dp[i] = 1;
		for (int j = 1; j < i; j++) {
			if (arr[i].right > arr[j].right) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
		temp = max(temp, dp[i]);
	}
	temp = abs(n - temp);
	cout << temp << endl;
}
