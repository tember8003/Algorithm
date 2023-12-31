#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <cmath>
using namespace std;
int n, m;
vector<int> v;
bool visited[9];
int arr[9];

void repeat(int cnt) {
	if (cnt == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i]<<" ";
		}
		cout << "\n";
		return;
	}
	for (int i = 0; i < n; i++) {
		if (visited[i]) {
			continue;
		}
		visited[i] = true;
		arr[cnt] = v[i];
		repeat(cnt + 1);
		visited[i] = false;
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int num;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	repeat(0);
}