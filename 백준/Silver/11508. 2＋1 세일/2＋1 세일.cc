#include <iostream>
#include <sstream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue<int, vector<int>, less<int>> pq;
	long long result = 0;
	int n; int num;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num;
		pq.push(num);
	}
	while (pq.size() >= 3) {
		int top = pq.top();
		pq.pop();
		int num1 = pq.top();
		pq.pop();
		int num2 = pq.top();
		pq.pop();
		result += top + num1;
	}
	if (pq.size() < 3) {
		while (!pq.empty()) {
			result += pq.top();
			pq.pop();
		}
	}
	cout << result << "\n";
}