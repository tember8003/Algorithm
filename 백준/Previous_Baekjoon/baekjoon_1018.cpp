//브루트포스 알고리즘
//제목:체스판 다시 칠하기
#define _CRT_SECURE_NO_WARNINGS
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <queue>

using namespace std;

string WB[8] = {
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW"
};
string BW[8] = {
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB",
		"BWBWBWBW",
		"WBWBWBWB"
};
string chess[51];
int white(int x, int y) {
	int cnt = 0;
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			if (chess[i + x][j + y] != WB[i][j]) {
				cnt++;
			}
		}
	}
	return cnt;
}
int black(int x, int y) {
	int cnt = 0;
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			if (chess[i + x][j + y] != BW[i][j]) {
				cnt++;
			}
		}
	}
	return cnt;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int num = 100000; int cnt = 0;
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> chess[i];
	}
	for (int i = 0; i+8 <= n; i++) {
		for (int j = 0; j+8 <= m; j++) {
			cnt = min(white(i, j), black(i, j));
			if (cnt < num) {
				num = cnt;
			}
		}
	}
	cout << num << "\n";
}
