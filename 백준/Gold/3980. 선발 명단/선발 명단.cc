#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <set>
using namespace std;
int n;
int ans = 0;
int lineup[11];
int member[11][11];
bool visited[11];


void repeat(int cnt,int sum) {
	if (cnt == 11) {
		if (sum > ans) {
			ans = sum;
		}
		return;
	}
	for (int i = 0; i < 11; i++) {
		if (visited[i]) {
			continue;
		}
		if (member[cnt][i] == 0) {
			continue;
		}
		visited[i] = true;
		repeat(cnt + 1, sum + member[cnt][i]);
		visited[i] = false;

	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	while (n--) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				cin >> member[i][j];
			}
		}
		ans = 0;
		fill_n(visited, 11, false);
		repeat(0,0);
		cout << ans << "\n";
	}

}