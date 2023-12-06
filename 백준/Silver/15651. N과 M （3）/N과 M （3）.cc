#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
//https://cryptosalamander.tistory.com/56#google_vignette 참고
using namespace std;
int n, m;
int arr[9];
bool visited[9];
void dfs(int num) {
	if (num == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	else {
		for (int i = 1; i <= n; i++) {
			visited[i] = true;
			arr[num] = i;
			dfs(num + 1);
			visited[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	dfs(0);
}