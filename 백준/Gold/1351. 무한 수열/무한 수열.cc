#include<iostream>
#include<algorithm>
#include<vector>
#include <map>
using namespace std;
long long n, p, q;
map<long long, long long> maps;
long long solve(long long n) {
	long long temp;
	if (maps.find(n)!=maps.end()) {
		return maps[n];
	}
	temp = solve(n / p) + solve(n / q);
	maps[n] = temp;
	return temp;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> p >> q;
	maps[0] = 1;
	if (n == 0) {
		cout << 1;
	}
	else {
		cout << solve(n / p) + solve(n / q);
	}

}