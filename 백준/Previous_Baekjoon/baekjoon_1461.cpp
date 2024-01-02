//그리디 문제
//제목:도서관
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int arr[100001] = { 0, };
long long ans = 0;
int temp = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		if (arr[i] < 0) {
			temp++;
		}
	}
	sort(arr, arr + n);
	for (int i = n - 1; i >= temp; i -= m) {
		ans += abs(arr[i]) * 2;
	}
	for (int i = 0; i < temp; i += m) {
		ans += abs(arr[i]) * 2;
	}
	ans -= max(abs(arr[0]), abs(arr[n - 1]));
	cout << ans << "\n";
}
