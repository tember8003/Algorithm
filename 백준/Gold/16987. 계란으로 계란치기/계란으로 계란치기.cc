#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <map>
#include <cmath>
using namespace std;

//https://prefer2.tistory.com/entry/%EB%B0%B1%EC%A4%80-16987%EB%B2%88-%EA%B3%84%EB%9E%80%EC%9C%BC%EB%A1%9C-%EA%B3%84%EB%9E%80%EC%B9%98%EA%B8%B0-c 참고

int n;
int strong[9];
int weight[9];
//bool visited[9];
int ans = 0;

void repeat(int cnt) {
	if (cnt == n) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			if (strong[i] <= 0) {
				temp++;
			}
		}
		ans = max(temp, ans);
		return;
	}
	if (strong[cnt] <= 0) {
		repeat(cnt + 1);
	}
	else {
		bool check = false;
		for (int i = 0; i < n; i++) {
			if (cnt == i) {
				continue;
			}
			if (strong[i] <= 0) {
				continue;
			}
			strong[i] -= weight[cnt];
			strong[cnt] -= weight[i];
			check = true;
			repeat(cnt + 1);
			strong[i] += weight[cnt];
			strong[cnt] += weight[i];
		}
		if (!check) {
			repeat(n);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> strong[i] >> weight[i];
	}
	repeat(0);
	cout << ans << "\n";
}