//dp문제
//제목: 줄어들지 않아
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;
long long ans[62];
int main() {
	long
		int n,t;
	cin >> n;
	long long dp[65][10];

	long long sum = 0;
	for (int i = 0; i < 10; i++) {
		dp[1][i] = 1;
		ans[1] += dp[1][i];
	}
	for (int i = 2; i < 65; i++) {
		sum = 0;
		for (int j = 0; j < 10; j++) {
			dp[i][j] = dp[i - 1][j] + sum;
			sum += dp[i - 1][j];
		}
		ans[i] = 0;
		for (int j = 0; j < 10; j++) {
			ans[i] += dp[i][j];
		}
	}
	while (n--) {
		cin >> t;
		cout << ans[t] << "\n";
	}
}
