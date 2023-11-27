#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

int cnt1 = 0;
int cnt2 = 0;

int matrix_path_rec(int m[][16], int i, int j) {
	if (i == 0 || j == 0) {
		cnt1++;
		return 0;
	}
	else {
		return (m[i][j] + (max((matrix_path_rec(m, i - 1, j)), (matrix_path_rec(m, i, j - 1)))));
	}
}
int matrix_path(int m[][16], int n) {
	return matrix_path_rec(m, n, n);
}

int dp_path(int m[][16], int n) {
	int dp[16][16];
	for (int i = 0; i <= n; i++) {
		dp[i][0] = 0;
	}
	for (int j = 1; j <= n; j++) {
		dp[0][j] = 0;
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cnt2++;
			dp[i][j] = m[i][j] + max(dp[i - 1][j], dp[i][j - 1]);
		}
	}
	return dp[n][n];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int m[16][16];
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> m[i][j];
		}
	}
	matrix_path(m, n);
	dp_path(m, n);
	cout << cnt1 << " " << cnt2;
}