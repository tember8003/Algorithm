//https://chan9.tistory.com/39 참고
#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	stack<char> stack;
	int answer = 0;
	string s;
	cin >> s;
	for (int i = 0; i < s.length(); i++) {
		if (s[i] == '(') {
			stack.push(s[i]);
		}
		else {
			if (s[i - 1] == '(') {
				stack.pop();
				answer += stack.size();
			}
			else {
				stack.pop();
				answer++;
			}
		}
	}
	cout << answer << "\n";
}