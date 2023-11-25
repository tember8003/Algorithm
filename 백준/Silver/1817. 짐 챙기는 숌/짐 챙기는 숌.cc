#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;
int arr[51];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	int count;
	int result = 0;
	cin >> n >> m;
	if (n == 0) {
		count = 0;
	}
	else {
		count = 1;
	}
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	for (int i = 0; i < n; i++) {
		if (result + arr[i] > m) {
			count++;
			result = arr[i];
		}
		else {
			result += arr[i];
		}
	}
	cout << count << "\n";
}