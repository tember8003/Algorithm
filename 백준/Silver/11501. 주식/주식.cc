#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int max_num = 0;
	int n;
	cin >> n;
	int num;
	for (int i = 0; i < n; i++) {
		int temp;
		vector<int> v;
		long long result = 0;
		cin >> num;
		for (int i = 0; i < num; i++) {
			cin >> temp;
			v.push_back(temp);
		}
		max_num = v.back();
		for (int i = num - 2; i >= 0; i--) {
			if (v[i] > max_num) {
				max_num = v[i];
			}
			else {
				result += max_num - v[i];
			}
		}
		cout << result << "\n";
	}
}