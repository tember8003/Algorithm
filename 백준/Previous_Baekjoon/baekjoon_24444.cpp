//그래프
//제목 알고리즘 수업 - 너비 우선 탐색 1
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

vector<int> arr[200001];
int visited[200001] = { 0, };
int result[200001];
int cnt = 0;

void bfs(int now) {
	queue<int> q;
	q.push(now);
	visited[now] = 1;
	cnt++;
	result[now] = cnt;
	while (!q.empty()) {
		int temp = q.front();
		q.pop();
		for (long unsigned int i = 0; i < arr[temp].size(); i++) {
			int inq = arr[temp][i];
			if (!visited[inq]) {
				cnt++;
				result[inq] = cnt;
				q.push(inq);
				visited[inq] = 1;
			}
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, r;
	cin >> n >> m >> r;
	for (int i = 1; i <=m; i++) {
		int u, v;
		cin >> u >> v;
		arr[u].push_back(v);
		arr[v].push_back(u);
	}
	for (int i = 1; i <= n; i++) {
		sort(arr[i].begin(), arr[i].end());
		reverse(arr[i].begin(), arr[i].end());
	}
	bfs(r);
	for (int i = 1; i <= n; i++) {
		cout << result[i] << '\n';
	}
	return 0;
}
