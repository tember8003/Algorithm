
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define MAX 100000000
long long colored[1001][3];
long long dp[1001][3];
long long ans = MAX;
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
		cin >> colored[i][0] >> colored[i][1] >> colored[i][2];
	}
	for (int color = 0; color <= 2; color++) {
		for (int i = 0; i <= 2; i++) {
			if (i == color) {
				dp[1][i] = colored[1][i];
			}
			else {
				dp[1][i] = MAX;
			}
		}
		for (int i = 2; i <= n; i++) {
			dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + colored[i][0];
			dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + colored[i][1];
			dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + colored[i][2];
		}
		for (int i = 0; i <= 2; i++) {
			if (i == color) {
				continue;
			}
			else {
				ans = min(ans, dp[n][i]);
			}
		}

	}
	cout << ans << "\n";
}
