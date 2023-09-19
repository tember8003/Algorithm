
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
	deque<string> dq;
	deque<string>::iterator iter;
	int n; int m; string temp;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> m;
		for (int j = 0; j < m; j++) {
			cin >> temp;
			if (j == 0) {
				dq.push_front(temp);
			}
			else {
				if (dq.front() >= temp) {
					dq.push_front(temp);
				}
				else {
					dq.push_back(temp);
				}
			}
		}
		for (int k = 0; k < dq.size(); k++) {
			cout << dq[k];
		}
		cout << "\n";
		dq.clear();
	}

}