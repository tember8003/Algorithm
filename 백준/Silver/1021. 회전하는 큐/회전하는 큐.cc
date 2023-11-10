#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int count = 0;
	deque<int> list;
	int n, m;
	int temp;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		list.push_back(i); //1~10
	}
	while (m--) {
		int num;
		cin >> num;
		int list_index=0;
		for (int i = 0; i < list.size(); i++) {
			if (list[i] == num) {
				list_index = i;
				break;
			}
		}
		if (list_index <= list.size() / 2) {
			for (int i = 0; i < list_index; i++) {
				list.push_back(list.front());
				list.pop_front();
				count++;
			}
			list.pop_front();
		}

		else {
			for (int i = 0; i < list.size() - list_index; i++) {
				list.push_front(list.back());
				list.pop_back();
				count++;
			}
			list.pop_front();
		}
	}
	cout << count << "\n";
}