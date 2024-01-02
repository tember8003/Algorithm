//수학,기하학
//문제: 터렛
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	int x1, y1, r1, x2, y2, r2;
	double d;
	for (int i = 0; i < n; i++) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		d = sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));
		if (d == 0) {
			if (r1 == r2) {
				cout << -1 << endl;
			}
			else {
				cout << 0 << endl;
			}
		}
		else {
			if (d == r1 + r2 || d==abs(r1-r2)) {
				cout << 1 << endl;
			}
			else if (d < r1 + r2 && d > abs(r1 - r2)) {
				cout << 2 << endl;
			}
			else {
				cout << 0 << endl;
			}
		}
	}

}
