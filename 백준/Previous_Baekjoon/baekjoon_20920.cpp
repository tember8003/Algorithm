//해시맵 사용
//제목:영단어 암기는 괴로워

//https://notepad96.tistory.com/56 참고

#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;
typedef pair<string, int> arr;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	map<string, int> maps;
	int n, m;
	string ans;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> ans;
		if (ans.length() < m) {
			continue;
		}
		else {
			maps[ans]++;
		}
	}
	vector<arr> v(maps.begin(), maps.end());
	sort(v.begin(), v.end(), [](arr a, arr b) {
		if (a.second == b.second) {
			if (a.first.length() == b.first.length()) {
				return a.first < b.first;
			}
			else {
				return a.first.length() > b.first.length();
			}
		}
		else {
			return a.second > b.second;
		}
		});
	for (arr it : v) {
		cout << it.first << "\n";
	}
}
