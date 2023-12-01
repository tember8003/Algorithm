#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

int dp[5001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	dp[3] = 1;
	dp[5] = 1;
	int n;
	cin >> n;
	for (int i = 6; i <= n; i++) {
		if (i % 5 == 0) {
			dp[i] = dp[i - 5] + 1;
		}
		else if (i % 3 == 0) {
			dp[i]= dp[i - 3] + 1;
		}
		else {
			if (dp[i - 3] != 0 && dp[i - 5] != 0) {
				dp[i] = min(dp[i - 3] + 1, dp[i - 5] + 1);
			}
		}
	}
	if (dp[n] == 0) {
		cout << -1 << "\n";
	}
	else {
		cout << dp[n] << "\n";
	}
}