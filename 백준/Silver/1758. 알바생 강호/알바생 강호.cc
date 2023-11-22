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

int arr[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	long long result = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n, greater<>());
	for (int i = 0; i < n; i++) {
		if (arr[i] - i < 0) {
			continue;
		}
		else {
			result += arr[i] - i;
		}
	}
	cout << result << "\n";
}