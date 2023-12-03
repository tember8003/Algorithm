#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;
int dp[1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	dp[1] = 1;
	dp[2] = 0;
	dp[3] = 1;
	dp[4] = 1;
	cin >> n;
	if (n <= 4) {
		if (dp[n] == 1) {
			cout << "SK" << "\n";
		}
		else {
			cout << "CY" << "\n";
		}
	}
	else {
		for (int i = 4; i <= n; i++) {
			if (dp[i - 1] + dp[i - 3] + dp[i - 4] == 3) {
				dp[i] = 0;
			}
			else {
				dp[i] = 1;
			}
		}
		if (dp[n] == 1) {
			cout << "SK" << "\n";
		}
		else {
			cout << "CY" << "\n";
		}
	}
}