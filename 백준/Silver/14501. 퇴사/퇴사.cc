
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int dp[20];
int day[20];
int money[20];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> day[i] >> money[i];
	}
	int final;
	for (int i = n; i > 0; i--) {
		final = i + day[i];
		if (final > n + 1) {
			dp[i] = dp[i + 1];
		}
		else {
			dp[i] = max(dp[i + 1], dp[final] + money[i]);
		}
	}
	cout << dp[1] << "\n";
}
