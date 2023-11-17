#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
//규칙만 찾으면 되는 문제. 괜히 시간이 0.25초가 아니었다.
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int sum = 0;
	int n, k;
	cin >> n >> k;
	for (int i = 1; i <= k; i++) {
		sum += i;
	}
	n -= sum;
	if (n < 0) {
		cout << -1 << "\n";
	}
	else {
		if (n % k == 0) {
			cout << k - 1 << "\n";
		}
		else {
			cout << k << "\n";
		}
	}
}