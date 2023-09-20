#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>
#include <deque>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int k; int n; int num;
	cin >> k;
	while (k--) {
		long long answer = 0;
		cin >> n;
		priority_queue<long long, vector<long long>, greater<long long>> q;
		for (int i = 0; i < n; i++) {
			cin >> num;
			q.push(num);
		}
		while (!q.empty()) {
			if (q.size() == 1) {
				break;
			}
			long long front = q.top();
			q.pop();
			long long back = q.top();
			q.pop();
			answer += front + back;
			q.push(front + back);
		}
		q.pop();
		cout << answer << "\n";
	}
}