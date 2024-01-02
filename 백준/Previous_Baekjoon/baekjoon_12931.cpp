//그리디 문제
//제목:두 배 더하기.
//문제가 할 수 있는 두 가지 연산으로 배열 값과 똑같이 만들면 되는데, 역으로 생각해서 배열 값을 두 가지 연산의 역으로 하여 0으로 만들면 되는 문제.
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
bool zerocheck = false;
bool check = false;
int arr[51];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int n;
	int count = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	while (true) {
		check = false;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				zerocheck = false;
				break;
			}
			zerocheck = true;
		}
		if (zerocheck) {
			break;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 != 0) {
				arr[i]--;
				count++;
				check = true;
			}
			if (i == n - 1 && check == false) {
				for (int j = 0; j < n; j++) {
					arr[j] /= 2;
				}
				count++;
			}
		}

	}
	cout << count << "\n";
}
