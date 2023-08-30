//https://yabmoons.tistory.com/556 참고
#include <iostream>
#include <string.h>
#include <algorithm>
#include <vector>
using namespace std;

int dp[10002];
int money[21];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t; int n,m;
	cin >> t;
	while (t--) {
		memset(dp, 0, sizeof(dp)); //0으로 초기화
		cin >> n;
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			cin >> money[i];
		}
		cin >> m;
		for (int i = 1; i <= n; i++) {
			for (int j = money[i]; j <= m; j++) {
				dp[j] = dp[j] + dp[j - money[i]];
			}
		}
		cout << dp[m] << "\n";
	}
}