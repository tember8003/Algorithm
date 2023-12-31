#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <cmath>
using namespace std;
int n;
string str;
//순열로 그냥 풀림

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str;
		sort(str.begin(), str.end());
		do {
			cout << str << "\n";
		} while (next_permutation(str.begin(), str.end()));
	}
}