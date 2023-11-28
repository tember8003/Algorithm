#include <iostream>
#include <sstream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>
using namespace std;
int vec[9];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	for (int i = 0; i < 9; i++) {
		cin >> vec[i];
	}
	sort(vec, vec + 9);
	do {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += vec[i];
		}
		if (sum == 100) {
			break;
		}
	} while (next_permutation(vec, vec + 9));
	for (int i = 0; i < 7; i++) {
		cout << vec[i] << "\n";
	}
}