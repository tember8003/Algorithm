#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	int num;
	bool check = true;
	priority_queue<int> pq;
	//queue<int> q;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> num;
		pq.push(num);
	}
	for (int i = 0; i < m; i++) {
		cin >> num;
		if (pq.top() < num) {
			check = false;
			break;
		}
		else {
			pq.push(pq.top() - num);
			pq.pop();
		}
	}
	if (check == true) {
		cout << 1 << "\n";
	}
	else {
		cout << 0 << "\n";
	}

}