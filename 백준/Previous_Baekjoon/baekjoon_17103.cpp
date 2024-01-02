//수학
//제목 골드바흐 파티션
//이 코드 또한 visual studio에서 이상한 값으로 도출되지만 백준에서는 맞게 나옴. 어째서?
#define _CRT_SECURE_NO_WARNINGS

#include <algorithm>
#include <iostream>
#include <cmath>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int count=0;
	int arr[1000001];
	int t,n;
	arr[1] = 1;
	for (int i = 2; i * i < 1000001; i++) {
		if (!arr[i]) {
			for (int j = 2; i * j < 1000001; j++)
				arr[i * j] = 1;
		}
	}
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		if (n == 4) {
			cout << 1 << endl;
		}
		else {
			for (int k = 3; k <= n; k+=2) {
				int j = n - k;
				if (j < k) {
					break;
				}
				else if (arr[k] == 0 && arr[j] == 0) {
					count++;
				}
			}
			cout << count << endl;
			count = 0;
		}
	}
}
