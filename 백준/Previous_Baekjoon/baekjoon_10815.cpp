//맵
//제목: 숫자 카드
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	map<int, int> maps;
	int n, a;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		maps[a] = 1;
	}
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		if (maps[a]) {
			cout << "1 ";
		}
		else {
			cout << "0 ";
		}
	}
}
