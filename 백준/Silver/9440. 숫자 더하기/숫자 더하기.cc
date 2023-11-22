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
//https://technicolour.tistory.com/20 참고
//zero가 있을 경우 swap 사용하는 것 이용.

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	int num;
	while (true) {
		int zero = 0;
		string num1 = "";
		string num2 = "";
		cin >> n;
		if (n == 0) {
			break;
		}
		vector<int> arr;
		for (int i = 0; i < n; i++) {
			cin >> num;
			if (num == 0) {
				zero++;
			}
			arr.push_back(num);
		}
		sort(arr.begin(), arr.end());
		if (zero == 1) {
			swap(arr[0], arr[2]);
		}
		else if (zero >= 2) {
			swap(arr[0], arr[zero]);
			swap(arr[1], arr[zero + 1]);
		}
		for (int i = 0; i < arr.size(); i++) {
			string temp = to_string(arr[i]);
			if (i % 2 == 0) {
				num1 += temp;
			}
			else {
				num2 += temp;
			}
		}
		cout << stoi(num1) + stoi(num2) << "\n";
	}
}