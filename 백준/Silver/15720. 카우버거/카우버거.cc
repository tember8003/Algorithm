#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue<int, vector<int>, less<int>> hamburger;
	priority_queue<int, vector<int>, less<int>> side;
	priority_queue<int, vector<int>, less<int>> drink;
	long long result_1 = 0;
	long long result_2 = 0;
	int h, s, d;
	int num;
	cin >> h >> s >> d;
	for (int i = 0; i < h; i++) {
		cin >> num;
		hamburger.push(num);
		result_1 += num;
	}
	for (int i = 0; i < s; i++) {
		cin >> num;
		side.push(num);
		result_1 += num;

	}
	for (int i = 0; i < d; i++) {
		cin >> num;
		drink.push(num);
		result_1 += num;

	}
	while (hamburger.size() + side.size() + drink.size() > 0) {
		int count = 0;
		int temp = 0;
		if (!hamburger.empty()) {
			temp += hamburger.top();
			hamburger.pop();
			count++;
		}
		if (!side.empty()) {
			temp += side.top();
			side.pop();
			count++;
		}
		if (!drink.empty()){
			temp += drink.top();
			drink.pop();
			count++;
		}
		if (count == 3) {
			result_2 += (int)temp * 0.9;
		}
		else {
			result_2 += temp;
		}
	}
	cout << result_1 << "\n";
	cout << result_2 << "\n";
}