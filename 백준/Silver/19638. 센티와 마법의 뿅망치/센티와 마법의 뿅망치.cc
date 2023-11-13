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

	priority_queue<int,vector<int>,less<int>> pq;
	int n, h, t;
	int num; int count = 0;
	bool check = false;
	cin >> n >> h >> t;
	for (int i = 0; i < n; i++) {
		cin >> num;
		pq.push(num);
	}
	for (int i = 0; i < t; i++) {
		int temp = pq.top();
		if (temp >= h) {
			if (temp != 1) {
				temp = temp / 2;
				pq.pop();
				pq.push(temp);
				count++;
			}
		}
		else {
			check = true;
			break;
		}

		if (pq.top() < h) {
			check = true;
			break;
		}


	}
	if (check == true) {
		cout << "YES" << "\n";
		cout << count << "\n";
	}
	else {
		cout << "NO" << "\n";
		cout << pq.top() << "\n";
	}
}