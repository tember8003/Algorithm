#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
//https://rujang.tistory.com/entry/%EB%B0%B1%EC%A4%80-15652%EB%B2%88-N%EA%B3%BC-M-4-CC 참고
using namespace std;
int n, m;
int arr[9];
//bool visited[9];
void dfs(int num,int cnt) {
	if (cnt == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
		for (int i = num; i <= n; i++) {
			arr[cnt] = i;
			dfs(i,cnt+1);
		}
	
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	dfs(1,0);
}