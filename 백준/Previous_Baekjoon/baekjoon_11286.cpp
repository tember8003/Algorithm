//우선순위 큐 문제
//제목:절댓값 힙
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
struct cmp {
	bool operator()(int a, int b) {
		if (abs(a) == abs(b)) {
			return a > b;
		}
		else {
			return abs(a) > abs(b);
		}
	}
};
priority_queue<int,vector<int>, cmp> arr;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,k,a;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		if (k == 0) {
			if (!arr.empty()) {
				cout << arr.top() << "\n";
				arr.pop();
			}
			else {
				cout << 0 << "\n";
			}
		}
		else {
			arr.push(k);
		}
	}

}
