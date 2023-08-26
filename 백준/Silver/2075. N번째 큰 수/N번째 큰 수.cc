#include<iostream>
#include<algorithm>
#include<vector>
#include <queue>
#include <map>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue<int, vector<int>, greater<int>> pq;
	int n,temp;
	cin >> n;
	for (int i = 0; i < n * n; i++) {
		cin >> temp;
		if (pq.size() >= n) {
			if (temp < pq.top()) {
				continue;
			}
			else {
				pq.push(temp);
				pq.pop();
			}
		}
		else {
			pq.push(temp);
		}

	}
	cout << pq.top() <<"\n";
}