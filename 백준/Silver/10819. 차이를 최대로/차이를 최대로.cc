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

	int n; int num;
	vector<int> v;
	long long max_num = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	do {
		long long result = 0;
		for (int i = 0; i < n-1; i++) {
			result += abs(v[i] - v[i + 1]);
		}
		if (max_num < result) {
			max_num = result;
		}

	} while (next_permutation(v.begin(), v.end()));

	cout << max_num << "\n";
}