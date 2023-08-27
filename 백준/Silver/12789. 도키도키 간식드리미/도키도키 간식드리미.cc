#include<iostream>
#include<algorithm>
#include<vector>
#include <stack>
#include <queue>
#include <map>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	stack<int> line;
	queue<int> sample;
	int n; int a;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		sample.push(a);
	}
	int count = 1;
	while (!sample.empty()) {
		int temp = sample.front();
		if (temp == count) {
			count++;
			sample.pop();
		}
		else {
			if (!line.empty() && line.top() == count) {
				line.pop();
				count++;
			}
			else {
				line.push(temp);
				sample.pop();
			}
		}
	}
	while (!line.empty()) {
		int temp = line.top();
		line.pop();
		if (temp != count) {
			cout << "Sad" << "\n";
			return 0;
		}
		count++;
	}
	cout << "Nice" << "\n";
	return 0;
}