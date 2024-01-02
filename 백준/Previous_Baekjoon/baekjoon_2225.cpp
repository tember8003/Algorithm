//dp문제
//제목:합분해

//https://www.youtube.com/watch?v=8mFiz8pNZOw 참고
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
long long dp[201][202];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k;
	cin >> n >> k;
	for (int i = 0; i <= n; i++) {
		for (int j = 1; j <= k; j++) {
			if (j == 1 || i==0) {
				dp[i][j] = 1;
			}
			else {
				dp[i][j] += (dp[i - 1][j] + dp[i][j - 1])%1000000000;
			}
		}
	}
	cout << dp[n][k] << "\n";
}
