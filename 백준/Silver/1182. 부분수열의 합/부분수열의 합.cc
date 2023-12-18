#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
//https://im-gonna.tistory.com/78 재귀방식 풀이 넘나 어려운 것.
using namespace std;
int result = 0;
int n, s;
int arr[21];
void sum(int num, int hap) {
	if (num == n) {
		if (hap == s) {
			result++;
		}
		return;
	}
	sum(num + 1, hap);
	sum(num + 1, hap + arr[num]);
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> s;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sum(0, 0);
	if (s == 0) {
		result--;
	}
	cout << result << "\n";
}