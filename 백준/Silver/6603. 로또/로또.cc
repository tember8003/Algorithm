#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

vector<int> num;
int ans[6];
int n;
int temp;

void repeat(int cnt,int idx) {
	if (cnt == 6) {
		for (int i = 0; i < 6; i++) {
			cout << ans[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = idx; i < n; i++) {
			ans[cnt] = num[i];
			repeat(cnt + 1, i + 1);
	}
}

int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	while (true) {
		cin >> n;
		if (n == 0) {
			break;
		}
		else {
			for (int i = 0; i < n; i++) {
				cin >> temp;
				num.push_back(temp);
			}
			sort(num.begin(),num.end());
			repeat(0, 0);
		}
		num.clear();
		cout << "\n";
	}
}