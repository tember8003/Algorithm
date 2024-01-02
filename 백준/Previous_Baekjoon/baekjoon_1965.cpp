//11055 가장 큰 증가하는 수열 문제랑 비슷함
//dp문제
//제목:상자 넣기
#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
int dp[1001];
int num[1001];
int n;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long ans = 0;
	long long temp = 0;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		dp[i] = 1;
		cin >> num[i];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= i; j++) {
			if (num[i] >num[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		if (temp < dp[i]) {
			temp = dp[i];
		}
	}
	cout << temp << endl;

}
