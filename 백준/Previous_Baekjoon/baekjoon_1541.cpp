//수학
//제목:잃어버린 괄호
#include <iostream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;

int result(string ans) {
	vector<int> log;
	int logger=0;
	int temp = 0;
	int sum = 0;
	bool minus = false;
	int length = ans.length();
	for (int i = 0; i <= length; i++) {
		temp = 0;
		if (i < length) {
			if (ans[i] == '+' || ans[i] == '-') {
				for (int j = 0; j < log.size(); j++) {
					temp += pow(10, logger - 1 - j) * log[j];
				}
				logger = 0;
				log.clear();
				if (minus == true) {
					sum -= temp;
				}
				else {
					sum += temp;
				}
				if (ans[i] == '-') {
					minus = true;
				}
			}
			else {
				log.push_back(ans[i] - '0');
				logger++;
			}

		}
		if (i == length) {
			for (int j = 0; j < log.size(); j++) {
				temp += pow(10, logger - 1 - j) * log[j];
			}
			if (minus == true) {
				sum -= temp;
			}
			else {
				sum += temp;
			}
		}

	}
	return sum;
}
int main() {
	string ans;
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> ans;
	cout << result(ans) << '\n';
	return 0;
}
