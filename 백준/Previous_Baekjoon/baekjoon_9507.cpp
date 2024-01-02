//다이나믹 프로그래밍
//제목: Generations of Tribbles
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	long long dp[70];
	dp[0] = 1;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	for (int i = 4; i <= 69; i++) {
		dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i-4];
	}
	int n,t;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> t;
		cout<<dp[t]<<endl;
	}
}
