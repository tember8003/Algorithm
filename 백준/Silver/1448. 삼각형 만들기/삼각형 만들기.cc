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
int arr[1000001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n; int num;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	for (int i = n - 1; i > 1; i--) {
		int top = arr[i];
		int num1 = arr[i - 1];
		int num2 = arr[i - 2];
		if (top < num1 + num2) {
			cout << top + num1 + num2 << "\n";
			return 0;
		}
	}
	cout << -1 << "\n";

}