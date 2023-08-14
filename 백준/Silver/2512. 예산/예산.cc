#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int arr[10002];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,m;
	long long sum = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		sum += arr[i];
	}
	cin >> m;
	sort(arr, arr + n);
	if (sum <= m) {
		cout << arr[n - 1] << "\n";
	}
	else {
		int left = 0; int right = m;
		int ans = 0;
		while (left <= right) {
			int result = 0;
			int mid = (left + right) / 2;
			for (int i = 0; i < n; i++) {
				if (arr[i] < mid) {
					result += arr[i];
				}
				else {
					result += mid;
				}
			}
			if (result <= m) {
				ans = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		cout << ans << "\n";
	}
}