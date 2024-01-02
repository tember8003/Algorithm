//그리디문제
//제목:센서
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> num;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k;
	cin >> n >> k;


	if (k >= n) {
		cout << 0 << "\n";
		return 0;
	}
	num.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> num[i];
	}
	sort(num.begin(),num.end());
	vector<int> dif;
	for (int i = 1; i < n; i++) {
		dif.push_back(num[i] - num[i-1]);
	}
	sort(dif.begin(), dif.end());
	int ans = 0;
	for (int i = 0; i < n - (k); i++) {
		ans += dif[i];
	}
	cout << ans << "\n";
}
