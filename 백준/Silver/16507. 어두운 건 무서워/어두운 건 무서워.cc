#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int arr[1001][1001];
long long sum[1001][1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int r, c, q;
	cin >> r >> c >> q;
	for (int i = 1; i <= r; i++) {
		for (int j = 1; j <= c; j++) {
			cin >> arr[i][j];
		}
	}
	for (int i = 1; i <= r; i++) {
		for (int j = 1; j <= c; j++) {
			if (i == 1) {
				sum[i][j] += arr[i][j] + sum[i][j - 1];
			}
			else if (j == 1) {
				sum[i][j] += arr[i][j] + sum[i - 1][j];
			}
			else {
				sum[i][j] += arr[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
			}
		}
	}
	int x1, y1, x2, y2;
	for (int i = 0; i < q; i++) {
		cin >> x1 >> y1 >> x2 >> y2;
		long long temp = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
		temp /= ((x2 - x1 + 1) * (y2 - y1 + 1));
		cout << temp << "\n";
	}
}