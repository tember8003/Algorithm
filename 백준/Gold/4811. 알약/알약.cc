#include<iostream>
#include<algorithm>
#include<vector>
#include <map>
using namespace std;

long long dp[31][31];
void solve() {
	for (int i = 0; i < 31; i++) {
		dp[0][i] = 1;
	}
	for (int w = 1; w < 31; w++) {
		for (int h = 0; h < 31; h++) {
			if (h == 0) {
				dp[w][0] = dp[w - 1][1];
			}
			else {
				dp[w][h] = dp[w - 1][h +1] + dp[w][h - 1];
			}
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	solve();
	while (true) {
		cin >> n;
		if (n == 0) {
			break;
		}
		cout << dp[n][0] << "\n";
	}
	
}