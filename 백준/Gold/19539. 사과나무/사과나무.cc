#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
//https://readble-ko.tistory.com/149 참고
//규칙을 도저히 못찾았다..
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n; int num;  int sum = 0;
	int temp_2 = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num;
		sum += num;
		temp_2 += num / 2;
	}

	if (sum % 3 != 0) {
		cout << "NO" << "\n";
	}
	else {
		if (temp_2 >= sum / 3) {
			cout << "YES" << "\n";
		}
		else {
			cout << "NO" << "\n";
		}
	}
}