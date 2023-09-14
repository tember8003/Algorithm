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
	int n;
	map<string, int> map;
	string name;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> name;
		map[name] += 1;
	}
	for (int i = 0; i < n - 1; i++) {
		cin >> name;
		map[name] += 1;
	}
	for (auto s : map) {
		if (s.second % 2 == 1) {
			cout << s.first << "\n";
		}
		else {
			continue;
		}
	}
}