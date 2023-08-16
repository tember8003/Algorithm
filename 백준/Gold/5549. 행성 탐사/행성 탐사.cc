#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
char arr[1001][1001];
struct check {
	int i = 0;
	int j=0;
	int o=0;
};
struct check carr[1001][1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m,k;
	cin >> m >> n;
	cin >> k;
	string temp;
	for (int a = 1; a <= m; a++) {
		cin >> temp;
		for (int b = 1; b <= n; b++) {
			arr[a][b] = temp[b - 1];
		}
	}
		for (int a = 1; a <= n; a++) {
			if (arr[1][a] == 'J') {
				carr[1][a].j = 1;
			}
			else if (arr[1][a] == 'I') {
				carr[1][a].i = 1;
			}
			else if (arr[1][a] == 'O') {
				carr[1][a].o = 1;
			}
			carr[1][a].i += carr[1][a-1].i;
			carr[1][a].j += carr[1][a-1].j;
			carr[1][a].o += carr[1][a-1].o;
		}
		for (int a = 1; a <= m; a++) {
			if (arr[a][1] == 'J') {
				carr[a][1].j = 1;
			}
			else if (arr[a][1] == 'I') {
				carr[a][1].i = 1;
			}
			else if (arr[a][1] == 'O') {
				carr[a][1].o = 1;
			}
			carr[a][1].i += carr[a - 1][1].i;
			carr[a][1].j += carr[a - 1][1].j;
			carr[a][1].o += carr[a - 1][1].o;
		}
		for (int a = 2; a <= m; a++) {
			for (int b = 2; b <= n; b++) {
				carr[a][b].i = carr[a - 1][b].i + carr[a][b - 1].i - carr[a - 1][b - 1].i;
				carr[a][b].j = carr[a - 1][b].j + carr[a][b - 1].j - carr[a - 1][b - 1].j;
				carr[a][b].o = carr[a - 1][b].o + carr[a][b - 1].o - carr[a - 1][b - 1].o;
				if (arr[a][b] == 'J') carr[a][b].j += 1;
				else if (arr[a][b] == 'I') carr[a][b].i += 1;
				else if (arr[a][b] == 'O') carr[a][b].o += 1;
			}
		}
		int x1, y1, x2, y2;
		for (int a = 0; a < k; a++) {
			cin >> x1 >> y1 >> x2 >> y2;
			int j = carr[x2][y2].j - carr[x1 - 1][y2].j - carr[x2][y1 - 1].j + carr[x1 - 1][y1 - 1].j;
			int i= carr[x2][y2].i - carr[x1 - 1][y2].i - carr[x2][y1 - 1].i + carr[x1 - 1][y1 - 1].i;
			int o =carr[x2][y2].o - carr[x1 - 1][y2].o - carr[x2][y1 - 1].o + carr[x1 - 1][y1 - 1].o;
			cout << j << " " << o << " " << i << "\n";
		}
}