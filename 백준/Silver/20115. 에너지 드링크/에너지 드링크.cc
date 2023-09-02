#include <iostream>
#include <string.h>
#include <algorithm>
#include <queue>
#include <vector>
#include <map>

using namespace std;
double arr[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n);
	double temp = arr[n - 1];
	for (int i = 0; i < n - 1; i++) {
		temp += arr[i] / 2;
	}
	cout << temp << "\n";
}