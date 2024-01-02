//dp문제
//제목: 가장 긴 바이토닉 부분 수열

//소스 코드
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long long arr[1001];
long long dp[1001];
long long dp2[1001];
long long temp = 0;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		dp[i] = 1;
		dp2[i] = 1;
	}
	for (int i = 1; i <= n; i++) {
		for (int j = i+1; j <= n; j++) {
			if (arr[i] < arr[j]) {
				if (dp[j] < dp[i] + 1) {
					dp[j] = dp[i] + 1;
				}
			}
		}
	}
	for (int i = n; i > 0; i--) {
		for (int j = i - 1; j > 0; j--) {
			if (arr[i] < arr[j]) {
				if (dp2[j] < dp2[i] + 1) {
					dp2[j] = dp2[i] + 1;
				}
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		temp = max(temp, dp[i] + dp2[i] - 1);
	}
	cout << temp << "\n";
}
