#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <cmath>
using namespace std;
int n, m;
int arr[9];
int temp[9];
bool visited[9];

void repeat(int cnt,int idx) {
	if (cnt == m) {
		for (int i = 0; i < m; i++) {
			cout << temp[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = idx; i < n; i++) {
		if (!visited[i]) {
			visited[i] = true;
			temp[cnt] = arr[i];
			repeat(cnt + 1,i+1);
			visited[i] = false;
		}

	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	repeat(0,0);
}