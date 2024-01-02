//dp문제
//1,2,3 더하기 5
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define max 1000000009
long long dp[100001][4]={0};
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	dp[1][1] = 1;
	dp[2][2] = 1;
	dp[3][1] = 1;
	dp[3][2] = 1;
	dp[3][3] = 1;
	int n,m;
	cin >> n;
	for (int i = 4; i <= 100000; i++) {
		dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % max;
		dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % max;
		dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % max;
	}
	for (int i = 0; i < n; i++) {
		cin >> m;
		cout << (dp[m][1] + dp[m][2] + dp[m][3])%max<< endl;
	}
}
