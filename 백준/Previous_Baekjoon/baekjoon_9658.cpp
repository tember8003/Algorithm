//dp문제
//돌게임 4
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;
int dp[1001];
int main() {
	//1 상근 승리 0 패배
	dp[1] = 0;
	dp[2] = 1;
	dp[3] = 0;
	dp[4] = 1;
	for (int i = 5; i < 1001; i++) {
		if (dp[i - 1] + dp[i -3] + dp[i - 4] == 3) {
			dp[i] = 0;
		}
		else {
			dp[i] = 1;
		}
	}
	int n;
	cin >> n;
	if (dp[n] == 1) {
		cout << "SK" << "\n";
	}
	else {
		cout << "CY" << "\n";
	}

}
