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
	int max_set = 1001; int max_single = 1001;
	int temp1, temp2;
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> temp1 >> temp2;
		if (max_set > temp1) {
			max_set = temp1;
		}
		if (max_single > temp2) {
			max_single = temp2;
		}
	}
	int calculate = min((max_set * (n / 6 + 1)), min((n / 6 * max_set + n % 6 * max_single), n * max_single));
	cout << calculate << "\n";

}