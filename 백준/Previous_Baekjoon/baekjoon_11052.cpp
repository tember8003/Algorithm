//다이나믹 프로그래밍
//제목: 카드 구매하기
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <math.h>
//https://www.youtube.com/watch?v=zHnM0R5at8s 참고
using namespace std;

int result[1002];
int dp[1002];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	dp[0] = result[0] = 0;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> result[i];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			dp[i] = max(dp[i],dp[i-j]+result[j]);
		}
	}
	cout << dp[n] << endl;
}
