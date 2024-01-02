//솔직히 이해안됨 visual studio 기준으로는 답이 틀리게 나오지만 백준 기준으로는 맞음. 비쥬얼 스튜디오가 뭔가 문제가 있는듯함.
//2번 예제를 활용해 이해하는게 가장 좋아보임 -> 3x3을 그린 후 (2,2) 즉 정 가운데를 기준으로 dp[2][2] += max(max(dp[1][2],dp[2][1]),dp[1][1])를 통해 dp[1][1]이 1이므로 dp[2][2]+= 1이랑 같음. 
//이런 식으로 dp[3][3]은 3이 되게 됨.
//다이나믹 프로그래밍
//제목:이동하기
#define _CRT_SECURE_NO_WARNINGS
#include <algorithm>
#include <iostream>
#include <cmath>
using namespace std;
int max(int a, int b) {
	if (a > b) {
		return a;
	}
	return b;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	int dp[1001][1001];
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> dp[i][j];
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			dp[i][j] += max(max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
		}
	}
	cout<<dp[n][m];
	return 0;
}
