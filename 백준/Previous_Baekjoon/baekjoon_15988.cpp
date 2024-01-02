//dp문제
//제목:1,2,3 더하기 3
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
//미리 선언해놔야 돌릴 수 있는 문제

int main() {
	long long plus[1000001];
	int n;
	int t;
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	plus[1] = 1;
	plus[2] = 2;
	plus[3] = 4;
	for (int i = 4; i < 1000001; i++) {
		plus[i] = (plus[i - 3] + plus[i - 2] + plus[i - 1])%1000000009;
	}
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> t;
		cout << plus[t] << endl;
	}
	return 0;
}
