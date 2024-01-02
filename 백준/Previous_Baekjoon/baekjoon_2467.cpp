//투포인터 문제
//제목: 용액
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
long long arr[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int left = 0; int right =n-1;
	long long ans = abs(arr[left]+arr[right]);
	int ans1 = arr[left]; int ans2 = arr[right];
	while (left < right) {
		int temp = arr[left] + arr[right];
		if (abs(temp) < ans) {
			ans =abs(temp);
			ans1 = arr[left];
			ans2 = arr[right];
		}

		if (temp < 0) {
			left++;
		}
		else {
			right--;
		}
	}
	cout <<ans1 << " " << ans2 << "\n";
}
