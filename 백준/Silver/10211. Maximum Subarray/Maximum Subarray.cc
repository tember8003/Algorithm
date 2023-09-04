#include <iostream>
#include <string.h>
#include <algorithm>
#include <queue>
#include <vector>
#include <map>

using namespace std;
int dp[1001];
int arr[1001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n,a;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		for (int i = 1; i <= a; i++) {
			cin >> arr[i];
		}
		int temp = -999999999;
		for (int i = 1; i <=a; i++) {
			dp[i] = max(0,dp[i-1]) + arr[i];
			temp = max(temp, dp[i]);
		}
		cout << temp << "\n";
	}
}