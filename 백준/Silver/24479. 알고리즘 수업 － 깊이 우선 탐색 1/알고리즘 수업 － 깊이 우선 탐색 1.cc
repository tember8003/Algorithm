
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> arr[100001];
int result[100001];
int visited[100001] = { 0, };
int cnt = 0;

void dfs(int now) {
	if (visited[now] == 1) {
		return;
	}
	visited[now] = 1;
	cnt++;
	result[now] = cnt;
	for (int i = 0; i < arr[now].size(); i++) {
		dfs(arr[now][i]);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, v;
	int x, y;
	cin >> n >> m >> v;
	for (int i = 1; i <= m; i++) {
		cin >> x >> y;
		arr[x].push_back(y);
		arr[y].push_back(x);
	}
	for (int i = 1; i <= n; i++) {
		sort(arr[i].begin(), arr[i].end());
	}
	dfs(v);
	for (int i = 1; i <= n; i++) {
		cout << result[i] << "\n";
	}
	return 0;
}
