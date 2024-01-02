//수학
//제목 수들의 합

#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long sum=0, temp = 1;
	int cnt =0;
	long long n;
	cin >> n;
	while (1) {
		sum += temp;
		temp++;
		if (sum > n) {
			temp--;
			break;
		}
		cnt++;
	}
	cout << cnt;
	return 0;
}
