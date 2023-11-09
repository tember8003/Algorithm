#include <iostream>
#include <sstream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>
using namespace std;
int dp[10000001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	dp[1] = 1; dp[2] = 2; dp[3] = 3;
	if (n >= 4) {
		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10;
		}
		cout << dp[n] << "\n";
	}
	else {
		cout << dp[n] << "\n";
	}
}