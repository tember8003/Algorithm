#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
using namespace std;
int result[1002];
int dp[1002];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> result[i];
	}

	for (int i = 1; i <= n; ++i) {
		dp[i] = result[i];
		for (int j = 1; j < i; j++) {
			dp[i] = min(dp[i], dp[i - j] + result[j]);
		}
	}
	cout << dp[n] << endl;
}