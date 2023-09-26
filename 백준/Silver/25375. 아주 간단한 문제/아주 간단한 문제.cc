#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n; long long a, b;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		if (2 * a <= b && b % a == 0) {
			cout << 1 << "\n";
		}
		else {
			cout << 0 << "\n";
		}
	}
}
