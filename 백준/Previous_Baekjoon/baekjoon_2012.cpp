//그리디 문제
//제목:등수 매기기
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	long long arr[500001];
	long long temp[500001];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	for (int i = 0; i < n; i++) {
		temp[i] = i + 1;
	}
	long long ans = 0;
	for (int i = 0; i < n; i++) {
		ans += abs(arr[i] - temp[i]);
	}
	cout << ans << "\n";
}
