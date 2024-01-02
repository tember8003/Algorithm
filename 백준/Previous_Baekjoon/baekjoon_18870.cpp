//정렬
//제목 좌표 압축
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool binary_search(vector<int>& arr, int len, int target) {
	int low = 0, high = len - 1;

	while (low <= high) {
		int mid = (low + high) / 2;

		//원하는 값을 찾았다면 true 반환
		if (target == arr[mid])	return true;

		// 원하는 값이 더 작다면 검사 범위를 더 낮게 잡아야 한다.
		if (target < arr[mid]) {
			high = mid - 1;
		}
		// 원하는 값이 더 크다면 검사 범위를 더 크게 잡아야 한다.
		else if (target > arr[mid]) {
			low = mid + 1;
		}
	}
	return false; // 마지막까지 못찾는다면 false 반환
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector<int> arr;
	int n;
	int a;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		arr.push_back(a);
	}
	vector<int> temp = arr;
	sort(arr.begin(), arr.end());
	arr.erase(unique(arr.begin(), arr.end()), arr.end());
	int size = arr.size();
	int count = 0;
	for (int i = 0; i < n; i++) {
		int low = 0;
		int high = size;
		int mid = (low + high) / 2;
		while (true) {
			mid = (low + high) / 2;
			if (arr[mid] > temp[i]) {
				high = mid - 1;
			}
			else if (arr[mid] < temp[i]) {
				low = mid + 1;
			}
			else
				break;
		}
		cout << mid << " ";
	}
	return 0;
}
