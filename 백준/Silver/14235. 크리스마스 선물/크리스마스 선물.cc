
#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n; int temp;
	priority_queue<int> q;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		if (temp == 0) {
			if (q.size() == 0) {
				cout << -1 << "\n";
			}
			else {
				cout << q.top() << "\n";
				q.pop();
			}
		}
		else {
			int num;
			for (int j = 0; j < temp; j++) {
				cin >> num;
				q.push(num);
			}
		}
	}
}
