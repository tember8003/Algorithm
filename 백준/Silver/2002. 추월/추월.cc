#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>
#include <deque>

using namespace std;
int final[1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	int count = 0;
	string str;
	map<string, int>map;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str;
		map[str] = i;
	}
	for (int i = 0; i < n; i++) {
		cin >> str;
		final[i] = map[str];
	}
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			if (final[i] > final[j]) {
				count++;
				break;
			}
		}
	}
	cout << count << "\n";
}