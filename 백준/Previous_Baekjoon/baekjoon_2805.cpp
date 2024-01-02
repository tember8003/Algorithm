//이분 탐색 문제
//제목:나무 자르기

//단계별로 풀기에서 이분 탐색 전 단계 코드와 비슷하게 짬

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


long long arr[1000001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	int temp = 0;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		if (temp < arr[i]) {
			temp = arr[i];
		}
	}
	long long left = 1; long long right = temp; long long result = 0;
	while (left <= right) {
		long long sum = 0;
		int mid = (left + right) / 2;
		for (int i = 0; i < n; i++) {
			if (arr[i] < mid) {
				continue;
			}
			else {
				sum += arr[i] - mid;
			}
		}
		if (sum >= m) {
			left = mid + 1;
			if (result < mid) {
				result = mid;
			}
		}
		else {
			right = mid - 1;
		}
	}
	cout << result << "\n";
}
