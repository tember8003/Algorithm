//dp문제
//제목:제곱수의 합
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
//https://yabmoons.tistory.com/526 진짜 대단한 생각... 존경스러울 정도
using namespace std;
int dp[100010];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		dp[i] = i;
		for (int j = 1; j * j <= i; j++) {
			dp[i] = min(dp[i], dp[i - j * j] + 1);
		}
	}
	cout << dp[n] << endl;
	
}
