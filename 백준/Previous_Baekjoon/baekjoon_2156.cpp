//dp문제
//제목: 포도주 시식
#include <iostream>
using namespace std;

int max(int a, int b, int c) {
	int temp = max(a, b);
	return max(temp, c);
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int arr[10001];
	int dp[10001];
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	dp[1] = arr[1];
	dp[2] = arr[1] + arr[2];
	dp[3] = max(dp[2], arr[1] + arr[3], arr[2] + arr[3]);
	for (int i = 4; i <= n; i++) {
		dp[i] = max(dp[i - 1], dp[i - 2] + arr[i], arr[i] + arr[i - 1] + dp[i - 3]);
	}
	cout << dp[n] << "\n";
	return 0;
}
