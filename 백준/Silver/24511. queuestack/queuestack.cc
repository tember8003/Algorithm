#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;
bool check[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	queue<int> q;
	deque<int> dq;
	int num;
	for (int i = 0; i < n; i++) {
		cin >> num;
		if (num == 0) { //0 큐 1 스택
			check[i] = false;
		}
		else {
			check[i] = true;
		}
	}
	for (int i = 0; i < n; i++) {
		cin >> num;
		if (check[i] == false) {
			dq.push_back(num);
		}
	}
	int m;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> num;
		dq.push_front(num);
		cout << dq.back() << " ";
		dq.pop_back();
	}
}