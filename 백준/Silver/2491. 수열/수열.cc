#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>

using namespace std;
int arr[100001];
int dp[100001][2];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	cin >> n;
	int answer = 1;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		dp[i][0]=1;
		dp[i][1] = 1;
	}
	
	for (int i = 1; i < n; i++) {
		if (arr[i-1] <= arr[i]) {
			dp[i][1] = max(dp[i][1], dp[i - 1][1] + 1);
		}
		if (arr[i - 1] >= arr[i]) {
			dp[i][0] = max(dp[i][0], dp[i - 1][0] + 1);
		}
		answer = max(answer, max(dp[i][0], dp[i][1]));
	}
	cout << answer << "\n";
	
}