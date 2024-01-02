//11055와 비슷한 문제
//dp문제
//제목: 가장 긴 감소하는 부분 수열
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int dp[1001];
int arr[1001];
long long temp = 0;
int main() {
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		dp[i] = 1;
		cin >> arr[i];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j < i; j++) {
			if (arr[i] < arr[j]) {
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
