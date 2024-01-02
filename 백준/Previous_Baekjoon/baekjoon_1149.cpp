//dp문제
//제목:RGB거리
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
long long arr[3];
long long dp[1001][4];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,m;
	cin >> n;
	dp[0][0] = 0;
	dp[0][1] = 0;
	dp[0][2] = 0;
	for (int i = 1; i <= n; i++) {
		cin >> arr[0] >> arr[1] >> arr[2];
		dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + arr[0];
		dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + arr[1];
		dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + arr[2];
	}
	long long ans = min(dp[n][0],min( dp[n][1], dp[n][2]));
	cout << ans << "\n";
}
