//다이나믹 프로그래밍
//제목:거스름돈
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int temp2 = 0;
	int temp5 = 0;
	int ans = 0;
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	if (n == 1 || n == 3) {
		cout << -1 << endl;
	}
	else if (n % 5 == 0) {
		ans = n / 5;
		cout << ans << endl;
	}
	else {
		temp5 = n / 5;
		n -= temp5 * 5;
		ans += temp5;
		if (n % 2 == 1) {
			ans--;
			n += 5;
			temp2 = n / 2;
			n -= temp2 * 2;
			ans += temp2;
		}
		else {
			temp2 = n / 2;
			n -= temp2 * 2;
			ans += temp2;
		}
		cout << ans << endl;
	}

}
