//dp문제
//제목:쉬운 계단 수
//https://www.youtube.com/watch?v=SPVOKqMDerQ 를 통해 이해한 문제

#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;
long long dp[101][11];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	dp[1][0] = 0;
	for (int i = 1; i < 10; i++) {
		dp[1][i] = 1;
	}
	cin >> n;
	for (int i = 2; i < n + 1; i++) {
		for (int j = 0; j < 10; j++) {
			dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
			dp[i][j] %= 1000000000;
		}
		
	}
	long long sum = 0;
	for (int i = 0; i < 10; i++) {
		sum += dp[n][i];
	}
	sum %= 1000000000;
	cout << sum << "\n";
}
