#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	queue<int> queue;
	while (true) {
		int cnt;
		cin >> cnt;
		if (cnt == 0) {
			if (!queue.empty()) {
				queue.pop();
			}
		}
		else if (cnt == -1) {
			break;
		}
		else {
			if (queue.size() == n) {
				continue;
			}
			else {
				queue.push(cnt);
			}
		}
	}
	if (queue.size() == 0) {
		cout << "empty" << "\n";
	}
	else {
		while (queue.size() != 0) {
			cout << queue.front() << " ";
			queue.pop();
		}
	}

}