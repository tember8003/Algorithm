//누적 합
//제목:합 구하기

#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

int arr[100002];
long long sum[100002];
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,m;
	int a, b;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		sum[i] += arr[i] + sum[i - 1];
	}
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		cout << sum[b] - sum[a - 1] << "\n";
	}
}
