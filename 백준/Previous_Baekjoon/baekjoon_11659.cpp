//누적 합
//제목:구간 합 구하기 4
#include <iostream>
using namespace std;

int temp[1000001];
int binary(int t) {
	if (t == 1) {
		return 1;
	}
	else if (t == 2) {
		return 2;
	}
	else {
		if (temp[t] != 0) {
			return temp[t];
		}
		else {
			temp[t] = (binary(t - 1) + binary(t - 2)) % 15746;
			return temp[t];
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	cout << binary(n);
	return 0;
}
