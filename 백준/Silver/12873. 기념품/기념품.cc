#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	queue<int> q;
	cin >> n;
	for (int i = 0; i < n; i++) {
		q.push(i + 1);
	}
	long long check = 1; long long temp = 1;
	while (q.size() != 1) {
		check = (temp * temp * temp - 1) % q.size();
		for (long long i = 0; i < check; i++) {
			long long best = q.front();
			q.pop();
			q.push(best);
		}
		q.pop();
		temp++;
	}
	cout << q.front() << "\n";
}