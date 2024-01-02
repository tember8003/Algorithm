//투 포인터
//제목:부분합

//https://danidani-de.tistory.com/3 참고

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
	int n, s;
	cin >> n >> s;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int left = 0; int right = 0;
	long long hap = 0; int answer = 10000000;
	while (left<=right) {

		if(hap>= s) {
			answer = min(answer, right - left);
			hap -= arr[left];
			left++;
		}
		else if (right==n) {
			break;
		}
		else {
			hap += arr[right++];
		}
	}
	if (answer == 10000000) {
		cout << 0 << "\n";
	}
	else {
		cout << answer << "\n";
	}
}
