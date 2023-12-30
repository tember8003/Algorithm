#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <cmath>
using namespace std;
int n;
long long arr[1000001];
queue<long long> temp_q;
void result() {
	int count = 11;
	while (count <= n) {
		if (temp_q.empty()) {
			break;
		}
		long long temp = temp_q.front();
		temp_q.pop();
		int last = temp % 10;
		for (int i = 0; i < last; i++) {
			temp_q.push(temp * 10 + i);
			arr[count++] = temp * 10 + i;
		}
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for (int i = 1; i <= 10; i++) {
		temp_q.push(i - 1);
		arr[i] = i - 1;
	}
	cin >> n;
	result();
	if (n!=1 && arr[n] == 0) {
		cout << -1 << "\n";
	}
	else {
		cout << arr[n] << "\n";
	}
}