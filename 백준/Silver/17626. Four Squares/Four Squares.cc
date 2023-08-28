#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	vector<int>dp(n + 1, 0);
	dp[1] = 1;
	for (int i = 2; i <= n; i++) {
		int less = 2147483647;
		for (int j = 1; j * j <= i; j++) {
			int temp = i - j * j;
			less = min(less, dp[temp]);
		}
		dp[i] = less + 1;
	}
	cout << dp[n] << "\n";

}
