//제목:A → B
//그리디 알고리즘

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int a, b;
	int answer = 0;
	cin >> a >> b;
	while (a != b) {
		if (a > b) {
			answer = -1;
			break;
		}
		if (b % 2 == 0) {
			b = b / 2;
			answer++;
		}
		else if (b % 10 == 1) {
			b = b / 10;
			answer++;
		}
		else {
			answer = -1;
			break;
		}
		if (a == b) {
			answer++;
			break;
		}

	}
	cout << answer << "\n";
}
