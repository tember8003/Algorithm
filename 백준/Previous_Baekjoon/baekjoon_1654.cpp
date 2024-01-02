//이분탐색
//제목:랜선 자르기
//https://yongmemo.tistory.com/21 참고
#include<iostream>

#include<vector>

#include<algorithm>

using namespace std;

long long arr[10001];
long long temp = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k;
	cin >> k >> n;
	for (int i = 0; i < k; i++) {
		cin >> arr[i];
		if (temp < arr[i]) {
			temp = arr[i];
		}
	}
	long long left = 1; long long right = temp; long long mid; long long result = 0;
	while (left <= right) {
		long long cnt = 0;
		mid = (left + right) / 2;
		for (int i = 0; i < k; i++) {
			cnt += arr[i] / mid;
		}
		if (cnt >= n) {
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
