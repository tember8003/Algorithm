//수학
//제목:최소공배수
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

long long gcd(long long a, long long b) {
	long long r;
	while (b != 0) {
		r = a % b;
		a = b;
		b = r;
	}
	return a;
}
long long lcm(long long a, long long b) {
	return (a * b) / gcd(a, b);
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long a, b;
	cin >> a >> b;
	long long result = lcm(a, b);
	cout << result << "\n";
}
