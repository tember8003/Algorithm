//재귀
//제목 별 찍기 - 10
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;
int n;
void getin(int i,int j,int n) {
	if ((i / n) % 3 == 1 && (j / n) % 3 == 1) {
		cout << " ";
	}
	else {
		if (n / 3 == 0) {
			cout << "*";
		}
		else {
			getin(i, j, n/3);
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(static_cast<ostream*>(0));
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			getin(i, j, n);
		}
		cout << endl;
	}
}
