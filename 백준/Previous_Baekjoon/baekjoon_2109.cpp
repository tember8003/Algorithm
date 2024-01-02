//https://github.com/tember8003/cpp/blob/main/baekjoon_13904.cpp
//제출했던 문제랑 비슷해서 보고 참고함
//정렬 문제
//제목:순회강연
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>


using namespace std;
vector<pair<int, int>> arr;
//bool check[10001];
int visited[10001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	int a, b;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		arr.push_back(make_pair(a, b));
	}
	sort(arr.begin(), arr.end());
	
	for (int i = n - 1; i >= 0; i--) {
		int temp = arr[i].second;
		for (int j = temp; j >= 1; j--) {
			if (visited[j] == 0) {
				visited[j] = arr[i].first;
				break;
			}
		}
	}
	long long ans = 0;
	for (int i = 0; i < 10001; i++) {
		ans += visited[i];
	}
	cout << ans << "\n";
}
