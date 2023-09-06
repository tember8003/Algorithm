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
	queue<int> q;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}
	while (q.size() > 1) {
		cout << q.front() << " ";
		q.pop();
		int first = q.front();
		q.pop();
		q.push(first);
	}
	cout << q.front();

}

