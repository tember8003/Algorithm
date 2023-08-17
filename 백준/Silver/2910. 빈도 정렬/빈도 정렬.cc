#include<iostream>
#include<algorithm>
#include<vector>
#include <map>
using namespace std;
map<int, int> maps;
map<int, int> line;
bool compare(pair<int, int>& a, pair<int, int>& b) {
	if (a.second == b.second) {
		return line[a.first] < line[b.first];
	}
	return a.second > b.second;
}
int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, c,a;
	cin >> n >> c;
	for (int i = 0; i < n; i++) {
		cin >> a;
		maps[a]++;
		if (line[a] == 0) {
			line[a] = i + 1;
		}
	}
	vector<pair<int, int>> vec(maps.begin(), maps.end());
	sort(vec.begin(), vec.end(), compare);
	for (auto i : vec) {
		for (int j = 0; j < i.second; j++) {
			cout << i.first << " ";
		}
	}
	
}
