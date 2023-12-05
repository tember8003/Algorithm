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

long long factorial(int n) {
	if (n == 0) {
		return 1;
	}
	else {
		return factorial(n - 1) * n;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	cout << factorial(n) << "\n";
}