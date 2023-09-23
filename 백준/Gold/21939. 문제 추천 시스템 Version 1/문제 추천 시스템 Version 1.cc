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
	cin.tie(NULL); cout.tie(NULL);
	int n, num, problem; //n은 개수, num 번호 problem 난이도
	int m;
	cin >> n;
	multiset <pair<int, int>> hard;
	map<int, int> map;
	for (int i = 0; i < n; i++) {
		cin >> num >> problem;
		hard.insert(make_pair(problem, num));
		map[num] = problem;
	}
	cin >> m;
	for (int i = 0; i < m; i++) {
		string commend;
		cin >> commend;
		if (commend == "add") {
			int num, problem;
			cin >> num >> problem;
			hard.insert(make_pair(problem, num));
		}
		else if (commend == "recommend") {
			int temp;
			cin >> temp;
			if (temp == 1) {
				cout << prev(hard.end())->second << "\n";
			}
			else if (temp == -1) {
				cout << hard.begin()->second << "\n";
			}
		}
		else if (commend == "solved") {
			int num;
			cin >> num;
			hard.erase({ map[num],num });
		}
	}
}