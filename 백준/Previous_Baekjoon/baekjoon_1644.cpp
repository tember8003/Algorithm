//투포인터문제
//제목:소수의 연속합
//질문에 있는 것을 참고로 품.
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define MAX 4000000

using namespace std;
long long dp[MAX+1];
bool check[MAX+1];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	int count = 0;
	cin >> n;
	check[0] = check[1] = true;

	for (int i = 2; i <= sqrt(MAX); i++) {
		if (!check[i]) {
			for (int j = 2 * i; j <= MAX; j += i) {
				check[j] = true;
			}
		}
	}

	int left = 0; int right = 0; long long hap = 0;
	while (left<=right) {
		if (right>n) {
			break;
		}
		if (hap < n) {
			while (check[++right]) { //이게 가장 대단하다고 생각함.
			}
			hap += right;
		}
		else if (hap > n) {
			while (check[++left]) {}
			hap -= left;
		}
		else {
			count++;
			while (check[++right]) {
			}
			hap += right;
		}
	}
	cout << count << "\n";
}
