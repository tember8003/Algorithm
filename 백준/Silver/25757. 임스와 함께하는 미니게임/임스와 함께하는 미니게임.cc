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
	map<string,int> maps;
	string temp;
	int cnt = 0;
	int answer = 0;
	int n;
	char s;
	cin >> n;
	cin >> s;
	if (s == 'Y') {
		cnt = 1;
	}
	else if (s == 'F') {
		cnt = 2;
	}
	else if (s == 'O') {
		cnt = 3;
	}
	for (int i = 0; i < n; i++) {
		cin >> temp;
		maps[temp]++;
	}
	answer = maps.size() / cnt;
	cout << answer << "\n";
}