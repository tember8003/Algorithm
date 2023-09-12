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
	deque<int> dq;
	string temp;
	int n;
	int cnt;
	cin >> n;
	for(int i=0; i<n; i++){
		cin >> temp;
		if (temp[0] == '1') {
			cin >> cnt;
			dq.push_front(cnt);
		}
		else if (temp[0] == '2') {
			cin >> cnt;
			dq.push_back(cnt);
		}
		else if (temp[0] == '3') {
			if (!dq.empty()) {
				cout << dq.front() << "\n";
				dq.pop_front();
			}
			else {
				cout << -1 << "\n";
			}
		}
		else if (temp[0] == '4') {
			if (!dq.empty()) {
				cout << dq.back() << "\n";
				dq.pop_back();
			}
			else {
				cout << -1 << "\n";
			}
		}
		else if (temp[0] == '5') {
			cout << dq.size() << "\n";
		}
		else if (temp[0] == '6') {
			if (dq.empty()) {
				cout << 1 << "\n";
			}
			else {
				cout << 0 << "\n";
			}
		}
		else if (temp[0] == '7') {
			if (!dq.empty()) {
				cout << dq.front() << "\n";
			}
			else {
				cout << -1 << "\n";
			}
		}
		else if (temp[0] == '8') {
			if (!dq.empty()) {
				cout << dq.back() << "\n";
			}
			else {
				cout << -1 << "\n";
			}
		}
	}
}