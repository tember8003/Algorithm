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
	int number = 1;
	while (true) {
		stack<char> stacks;
		int count = 0;
		cin >> str;
		if (str[0] == '-') {
			break;
		}
		for (int i = 0; i < str.size(); i++) {
			if (str[i] == '}' && !stacks.empty() && stacks.top()=='{') {
				stacks.pop();
			}
			else {
				stacks.push(str[i]);
			}
		}
		while (!stacks.empty()) {
			char key1 = stacks.top();
			stacks.pop();
			char key2 = stacks.top();
			stacks.pop();
			if (key1 == key2) {
				count++;
			}
			else {
				count += 2;
			}
		}
		cout << number<<". " << count << "\n";
		number++;
	}
}