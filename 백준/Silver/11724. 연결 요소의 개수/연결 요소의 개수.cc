//https://velog.io/@matcha_/%EB%B0%B1%EC%A4%80-11724-%EC%97%B0%EA%B2%B0%EC%9A%94%EC%86%8C%EC%9D%98-%EA%B0%9C%EC%88%98-C-BFS-DFS
//참고 (dfs 풀이)
#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

vector<int> vect[1001];
int visited[1001];
int n, m;

void dfs(int index) {
	visited[index] = 1;
	for (int i = 0; i < vect[index].size(); i++) {
		int idx = vect[index][i];
		if (visited[idx] == 0) {
			dfs(idx);
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int u, v;
	int cnt = 0;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> u >> v;
		vect[u].push_back(v);
		vect[v].push_back(u);
	}
	for (int i = 1; i <= n; i++) {
		if (visited[i] == 0) {
			cnt++;
			dfs(i);
		}
	}
	cout << cnt << "\n";
}