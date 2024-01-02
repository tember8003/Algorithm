//dp문제
//제목:2*n 타일링 2
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int dp[1001];
	int pp[1001];
	int result[1001];
	int n;
	cin >> n;
	dp[0] = 1;
	dp[1] = 3;
	dp[2] = 5;
	if (n <= 3) {
		cout << dp[n - 1] << endl;
	}
	else {
		for (int i = 3; i < n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]*2) % 10007;
		}
		cout << dp[n - 1] << endl;
	}

}
