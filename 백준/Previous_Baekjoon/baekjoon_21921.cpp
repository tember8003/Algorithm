//누적 합
//제목:블로그


#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
long long sum[250002];
long long temp = 0;
int answer = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int x, n,a;
	cin >> n >> x;
	for (int i = 1; i <= n; i++) {
		cin >> a;
		sum[i] = a + sum[i - 1];
	}
	for (int i = x; i <= n; i++) {
		if (temp < sum[i] - sum[i - x]) {
			temp = sum[i] - sum[i - x];
			answer = 1;
		}
		else if (temp == sum[i] - sum[i - x]) {
			answer += 1;
		}
	}
	if (temp == 0) {
		cout << "SAD" << "\n";
	}
	else {
		cout << temp << "\n";
		cout << answer << "\n";
	}
}
