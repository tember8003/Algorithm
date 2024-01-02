//https://donggoolosori.github.io/2020/10/13/boj-11660/
//dp문제
//구간 합 구하기 5 <-내 생각과 너무 다른 코드였음 
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

long long dp[1025][1025];
long long arr[1025][1025];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,m;
	long long max;
	int x1, y1, x2, y2;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> arr[i][j];
			dp[i][j] = dp[i - 1][j]+dp[i][j-1]-dp[i-1][j-1]+arr[i][j];
		}
	}

	for (int i = 0; i < m; i++) {
		max = 0;
		cin >> x1 >> y1 >> x2 >> y2;
		max = dp[x2][y2] - dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
		cout << max << '\n';
	}
}
