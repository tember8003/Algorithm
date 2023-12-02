#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector<bool> arr(1000);
	fill(arr.begin(), arr.end(), true);
	
	int n;
	cin >> n;
	for (int i = 123; i <= 999; i++) {
		string temp = to_string(i);
		if (temp[0] == temp[1] || temp[1] == temp[2] || temp[2] == temp[0]) {
			arr[i] = false;
		}
		if (temp[0] - '0' == 0 || temp[1] - '0' == 0 || temp[2] - '0' == 0){
			arr[i] = false;
		}
	}
	int num;
	int strike;
	int ball;
	while (n--) {
		cin >> num >> strike >> ball;
		for (int i = 123; i <= 999; i++) {
			int count_s = 0;
			int count_b = 0;
			if (arr[i] == true) {
				string str_n = to_string(num);
				string str_i = to_string(i);

				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (j == k && str_n[k] == str_i[j]) {
							count_s++;
						}
						if (j != k && str_n[k] == str_i[j]) {
							count_b++;
						}
					}
				}
				if (count_s != strike || count_b != ball) {
					arr[i] = false;
				}
			}
		}
	}
	int count = 0;
	for (int i = 123; i <= 999; i++) {
		if (arr[i] == true) {
			count++;
		}
	}
	cout << count << "\n";
}