#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

long long sum[301][301];
int arr[301][301];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, k;
	int x1, y1, x2, y2;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			cin >> arr[i][j];
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
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
	cin >> k;
	for (int i = 0; i < k; i++) {
		cin >> x1 >> y1 >> x2 >> y2;
		long long temp = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
		cout << temp << "\n";
	}
}