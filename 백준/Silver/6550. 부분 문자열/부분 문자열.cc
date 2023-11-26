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
	string str;
	string temp;
	while (cin>>temp>>str) {
		bool check = false;
		int right = 0;
		for (int i = 0; i < str.length(); i++) {
			if (temp[right] == str[i]) {
				right++;
			}
			if (right == temp.length()) {
				check = true;
				break;
			}
		}
		if (check) {
			cout << "Yes" << "\n";
		}
		else {
			cout << "No" << "\n";
		}
	}
}