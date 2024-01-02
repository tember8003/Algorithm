//dp 문제
//제목: 카드 구매하기 2
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
/*
  1 5 6 7
dp[1]=1
dp[2]=5
dp[2]=2
dp[3]=6
dp[3]=3
dp[4]=7
dp[4]=4 <-정답
*/
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
