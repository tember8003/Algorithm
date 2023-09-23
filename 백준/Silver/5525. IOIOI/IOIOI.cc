#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>
#include <set>
#include <deque>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m; int answer = 0;
	string str;
	cin >> n >> m >> str;
	for (int i = 0; i < m; i++) {
		int temp = 0;
		if (str[i] == 'O') {
			continue;
		}
		while (str[i + 1] == 'O' && str[i + 2] == 'I') {
			temp++;
			if (temp == n) {
				answer++;
				temp--;
			}
			i += 2;
		}
	}
	cout << answer << "\n";
}