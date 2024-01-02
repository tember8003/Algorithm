//다이나믹 프로그래밍
//제목:피보나치 함수
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,k;
	cin >> n;
	long long dp[41][2];
	dp[0][0] = 1; dp[0][1] = 0; dp[1][0] = 0; dp[1][1] = 1; dp[2][0] = 1; dp[2][1] = 1;
	for (int i = 3; i <= 40; i++) {
		dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
		dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
	}
	for (int i = 0; i < n; i++) {
		cin >> k;
		cout << dp[k][0] << " " << dp[k][1] << endl;
	}
}
