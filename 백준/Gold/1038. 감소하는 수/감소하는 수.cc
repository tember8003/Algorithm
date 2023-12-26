#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

queue<long long> temp_q;
long long arr[1000001];
int n;

void result() {
	int count = 10;
	while (count<=n) {
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
	cout.tie(NULL);
	cin.tie(NULL);
	for (int i = 1; i <= 9; i++) {
		temp_q.push(i);
		arr[i] = i;
	}

	cin >> n;
	result();
	if (n != 0 && arr[n]==0) {
		cout << -1 << "\n";
	}
	else {
		cout << arr[n] << "\n";
	}
}