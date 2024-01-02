//정렬+투포인터 문제
//제목:두 수의 합
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
	int n,ans;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	cin >> ans;
	int result = 0;
	sort(arr, arr + n);
	int left = 0; int right = n-1;
	while (true) {
		if (left >= right) {
			break;
		}
		if (arr[left] + arr[right] < ans) {
			left++;
		}
		else if (arr[left] + arr[right] > ans) {
			right--;
		}
		else if (arr[left] + arr[right] == ans) {
			result++;
			left++;
			right--;
		}


	}
	cout << result << "\n";
}
