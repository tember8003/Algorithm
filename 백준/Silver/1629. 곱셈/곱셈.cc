#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

long long check(long long a,long long b,long long c) {
	long long temp = 1;
	if (b == 0) {
		return 1;
	}
	else {
		while (b > 0) {
			if (b % 2 == 1) {
				temp = (temp * a) % c;
			}
			a = ((a % c) * (a % c)) % c;
			b /= 2;
		}
		return temp;
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long a, b, c;
	cin >> a >> b >> c;
	cout << check(a, b, c) << "\n";
}