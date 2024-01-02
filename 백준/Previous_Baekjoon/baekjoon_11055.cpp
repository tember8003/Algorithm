//1965와 똑닮은 알고리즘
//dp문제
//제목:가장 큰 증가하는 부분 수열
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
		cin >> num[i];
		dp[i] = num[i];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j <= i; j++) {
			if (num[i] >num[j]) {
				dp[i] = max(dp[i], dp[j] + num[i]);
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
