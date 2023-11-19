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
	priority_queue<int, vector<int>, less<int>> pq;
	int n; int num;
	long long gold = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num;
		pq.push(num);
	}
	while (pq.size() > 1) {
		int top = pq.top();
		pq.pop();
		int rest = pq.top();
		pq.pop();
		gold += top + rest;
		pq.push(top);
	}
	cout << gold << "\n";
}