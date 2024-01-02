//동적 프로그래밍 문제.
//원래 자바로 작성하려 했으나, char형 입력받는 부분에서 고민하다가 c++로 갈아탐
//https://khj0426.tistory.com/170 참고
//제목:욱제는 사과팬이야

#define _CRT_SECURE_NO_WARNINGS
#include <algorithm>
#include <iostream>
using namespace std;
#define temp 1000000009

int main() {
	int n, m;
	cin >> n >> m;
	char arr[3001][3001];
	int dp[3001][3001];
	dp[0][0] = 1;
	bool end = false;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
			dp[i][j] = 1;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (i == n - 1 && j == m - 1) {
				end = true;
				break;
			}
			if (arr[i][j] == 'B') {
				if (i + 1 < n) {
					dp[i + 1][j] = dp[i][j] % temp + dp[i + 1][j] % temp;
				}
				if (j + 1 < m) {
					dp[i][j + 1] = dp[i][j] % temp + dp[i][j + 1] % temp;
				}
			}
			else if (arr[i][j] == 'S') {
				if (i + 1 < n) {
					dp[i + 1][j] = dp[i][j] % temp + dp[i + 1][j] % temp;
				}
			}
			else if (arr[i][j] == 'E') {
				if (j + 1 < m) {
					dp[i][j + 1] = dp[i][j] % temp + dp[i][j + 1] % temp;
				}
			}
		}
		if (end) {
			break;
		}
	}
	printf("%d", dp[n - 1][m - 1] % temp);
}
