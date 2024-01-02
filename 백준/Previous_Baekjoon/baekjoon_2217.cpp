//그리디문제
//https://ongveloper.tistory.com/326
//제목: 로프
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int compare(const void* a, const void* b)
{
	const int* x = (int*)a;
	const int* y = (int*)b;

	if (*x > *y)
		return 1;
	else if (*x < *y)
		return -1;

	return 0;
}
int arr[100001];
int ans = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	qsort(arr, n, sizeof(int), compare);
	for (int i = 0; i < n; i++) {
		ans = max(ans, (n - i) * arr[i]);
	}
	cout << ans << "\n";
}
