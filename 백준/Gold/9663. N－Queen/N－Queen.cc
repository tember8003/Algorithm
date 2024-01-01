#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;
int n;
int chess[16][16];

bool isSafe(vector<int>& board, int cnt, int check) {
	for (int past_row = 0; past_row < cnt; past_row++) {
		if (board[past_row] == check || abs(past_row-cnt) == abs(board[past_row]-check)) {//같은 행,열,대각선에 있으면 안됨.
			return false;
		}
	}
	return true;
}

void solve(vector<int>& board, int cnt, long long& ans) {
	//cnt를 행으로 설정
	if (cnt == n) {
		ans++;
		return;
	}
	for (int i = 0; i < n; i++) { //열로 설정
		if (isSafe(board, cnt, i)) {  
			board[cnt] = i;
			solve(board, cnt + 1, ans);
			board[cnt] = -1;
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	vector<int> chessboard(n, -1);
	long long ans = 0;
	solve(chessboard, 0, ans);
	cout << ans << "\n";
}
