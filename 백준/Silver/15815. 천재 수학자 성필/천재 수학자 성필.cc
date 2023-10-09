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
	stack<int> s;
	string temp;
	cin >> temp;
	for (int i = 0; i < temp.length(); i++) {
		char cnt = temp[i];
		if (cnt >= '0' && cnt <= '9') {
			s.push(cnt - '0');
		}
		else {
			int a, b;
			a = s.top();
			s.pop();
			b = s.top();
			s.pop();
			if (cnt == '+') {
				s.push(b + a);
			}
			else if (cnt == '-') {
				s.push(b - a);
			}
			else if (cnt == '*') {
				s.push(b * a);
			}
			else if (cnt == '/') {
				s.push(b / a);
			}
		
		}
	}
	cout << s.top() << "\n";
}