#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

deque<pair<int, int>> dq;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n; int num;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num;
		dq.push_back(make_pair(num, i + 1));
	}
	while (true) {

		int front = dq.front().first;
		cout << dq.front().second << " ";
		dq.pop_front();
		if (front > 0) {
			for (int i = 0; i < front-1; i++) {
				dq.push_back(dq.front());
				dq.pop_front();
			}
		}
		else if (front < 0) {
			for (int i = 0; i < (-1) * front; i++) {
				dq.push_front(dq.back());
				dq.pop_back();
			}
		}
		if (dq.size()==1) {
			break;
		}
	}
	cout << dq.front().second << "\n";
}