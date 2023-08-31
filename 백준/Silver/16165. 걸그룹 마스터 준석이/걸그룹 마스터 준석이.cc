//https://haerang94.tistory.com/472 참고
#include <iostream>
#include <string.h>
#include <algorithm>
#include <queue>
#include <vector>
#include <map>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	map<string, vector<string>> member;
	map<string, string> group;
	string name; int mem; string girlname;
	int n; int m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> name;
		cin >> mem;
		vector<string> temp;
		for (int j = 0; j < mem; j++) {
			cin >> girlname;
			temp.push_back(girlname);
			group[girlname] = name;
		}
		member[name] = temp;
	}
	int num; string quiz;
	for (int i = 0; i < m; i++) {
		cin >> quiz;
		cin >> num;
		if (num == 0) {
			vector<string> ans(member[quiz]);
			sort(ans.begin(), ans.end());
			for (auto m : ans) {
				cout << m << "\n";
			}
		}
		else {
			cout << group[quiz] << "\n";
		}
	}
}