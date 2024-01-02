//브루트포스 문제 , 이분탐색 문제
//제목:두 용액
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int arr[100001];
int n;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	int right = 0; int left = n - 1;
	int ans = abs(arr[left] + arr[right]);
	int countx = arr[right]; int county = arr[left];
	while (right < left) {
		if (abs(arr[right] + arr[left]) < ans) {
			ans = abs(arr[right] + arr[left]);
			countx = arr[right]; county = arr[left];
		}
		if (arr[right] + arr[left] < 0) {
			right++;
		}
		else if (arr[right] + arr[left] > 0) {
			left--;
		}
		else if (arr[right] + arr[left] == 0){
			countx = arr[right]; county = arr[left];
			break;
	}
	}
	cout << countx << " " << county << "\n";
}
