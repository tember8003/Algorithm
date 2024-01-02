//dp문제
//제목:병사 배치하기

#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n;
	cin >> n;
	long long dp[2001];
	long long arr[2001];
	long long temp = 0;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		dp[i] = 1;
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j < i; j++) {
			if (arr[i] < arr[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		if (dp[i] > temp) {
			temp = dp[i];
		}
	}
	cout << n-temp << endl;
}
