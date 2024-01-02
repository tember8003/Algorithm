//dp문제
//제목 이친수
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;
long long dp[91][2] = { 0 };
//https://www.acmicpc.net/board/view/68825 참고
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < 2; j++) {
			if (i == 1) {
				dp[1][1] = 1;
				dp[1][0] = 0;
			}
			if (i > 1) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][0] + dp[i - 1][1];
				}
				else if (j == 1) {
					dp[i][j] = dp[i - 1][0];
				}
			}
		}
	}
	long long result = dp[n][0] + dp[n][1];
	cout << result << endl;
}
