//투포인터 문제
//제목:용액 합성하기
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int arr[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int ans = arr[0] + arr[n - 1];
	int result = abs(arr[0] + arr[n - 1]);
	int left = 0; int right = n - 1;
	while (left < right) {
		int temp = arr[left] + arr[right];
		if (abs(temp) < result) {
			ans = temp;
			result = abs(temp);
		}

		if (temp < 0) {
			left++;
		}
		else {
			right--;
		}
	}
	cout << ans << "\n";
}
