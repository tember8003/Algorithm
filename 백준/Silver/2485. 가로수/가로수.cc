#include<iostream>
#include<algorithm>
#include<vector>
#include <queue>
#include <map>
using namespace std;
int way[100001];
int tree[100001];
int gcd(int a, int b) {
	if (b == 0) {
		return a;
	}
	else {
		return gcd(b, a % b);
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tree[i];
		if (i >= 1) {
			way[i - 1] = tree[i] - tree[i - 1];
		}
	}
	int min = way[0]; int count = 0;
	sort(tree, tree + n);
	for (int i = 1; i < n-1; i++) {
		min = gcd(min, way[i]);
	}
	for (int i = 0; i < n - 1; i++) {
		count += (way[i] / min) - 1;
	}
	cout << count << "\n";
}