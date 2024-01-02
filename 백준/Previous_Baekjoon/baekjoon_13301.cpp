//dp문제
//확실히 쉬움 ㅇㅇ..
//제목:타일 장식물
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;



int main() {
	long long dp[81];
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 2;
	long long temp = 0;
	cin >> n;
	if (n <= 3) {
		temp = (dp[n - 1] + dp[n]) * 2 + dp[n] * 2;
		cout <<temp << endl;
	}
	else {
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		temp = (dp[n - 1] + dp[n]) * 2 + dp[n] * 2;
		cout << temp << endl;
	}
}
