#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;
//https://ongveloper.tistory.com/150 코드 참고 x 풀이 참고 o
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k;
	cin >> n >> k;
	int answer = 0;
	if (k >= n) {
		cout << 0 << "\n";
	}
	else {
		while (true) {
			int temp = n;
			int count = 0;
			while (temp > 0) {
				if (temp % 2 == 0) {
					temp /= 2;
				}
				else {
					temp /= 2;
					count++;
				}
			}
			if (count > k) {
				n++;
				answer++;
			}
			else {
				break;
			}
		}
		cout << answer << "\n";
	}
	return 0;
}