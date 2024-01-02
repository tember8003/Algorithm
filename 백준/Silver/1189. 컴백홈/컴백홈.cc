#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <set>

using namespace std;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int r, c, k;
int board[6][6];
bool visited[6][6];
int cnt = 0;

void repeat(int y,int x,int distance){
	if (x == c - 1 && y == 0 && distance == k) {//오른쪽 위 도착하면 끝.
		cnt++;
		return;
	}
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < 0 || nx >= c || ny < 0 || ny >= r) {
			continue;
		}
		if (visited[ny][nx] || board[ny][nx]) {
			continue;
		}
		visited[ny][nx] = true;
		repeat(ny, nx, distance + 1);
		visited[ny][nx] = false;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> r >> c >> k;
	char temp;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> temp;
			if (temp == 'T') {
				board[i][j] = 1;
			}
		}
	}
	visited[r - 1][0] = true;//왼쪽 아래 점에서 시작
	repeat(r - 1, 0, 1);
	cout << cnt << "\n";
}