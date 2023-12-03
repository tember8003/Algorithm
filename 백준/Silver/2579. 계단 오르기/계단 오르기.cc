#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

//https://yabmoons.tistory.com/20 문제 풀이 보면서 이해함.

int dp[301];
int stairs[301];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> stairs[i];
	}
	dp[1] = stairs[1];
	dp[2] = stairs[1] + stairs[2];
	for (int i = 3; i <= n; i++) {
		dp[i] = max((dp[i - 3] + stairs[i - 1] + stairs[i]), (dp[i - 2] + stairs[i]));
	}
	cout << dp[n] << "\n";
}