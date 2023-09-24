#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>
#include <set>
#include <deque>
using namespace std;

priority_queue<int, vector<int>, greater<int>> min_q;
priority_queue<int, vector<int>, less<int>> max_q;
map<int, int> cnt;

void insert(int n) {
	min_q.push(n);
	max_q.push(n);
	cnt[n]++;
}
void deleteMin() {
	if (!min_q.empty()) {
		cnt[min_q.top()]--;
		min_q.pop();
	}
}
void deleteMax() {
	if (!max_q.empty()) {
		cnt[max_q.top()]--;
		max_q.pop();
	}
}
void check() {
	while (!min_q.empty() && cnt[min_q.top()] == 0) {
		min_q.pop();
	}
	while (!max_q.empty() && cnt[max_q.top()] == 0) {
		max_q.pop();
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	int k; char temp; int num;
	cin >> n;
	for (int i = 0; i < n; i++) {
		while (!min_q.empty()) {
			min_q.pop();
		}
		while (!max_q.empty()) {
			max_q.pop();
		}
		cnt.clear();
		cin >> k;
		for (int j = 0; j < k; j++) {
			cin >> temp >> num;
			if (temp == 'I') {
				insert(num);
			}
			else {
				if (num == 1) {
					deleteMax();
				}
				else {
					deleteMin();
				}
				check();
			}
		}
		check();
		if (max_q.empty() || min_q.empty()) {
			cout << "EMPTY" << "\n";
		}
		else {
			cout << max_q.top() << " " << min_q.top() << "\n";
		}
	}


}