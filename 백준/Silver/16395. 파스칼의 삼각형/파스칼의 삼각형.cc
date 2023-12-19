#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;
int arr[31][31];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,k;
	arr[1][1] = 1;
	arr[2][1] = 1; arr[2][2] = 1;
	for (int i = 3; i < 31; i++) {
		for (int j = 1; j <= i; j++) {
			arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
		}
	}
	cin >> n >> k;
	cout << arr[n][k] << "\n";
}