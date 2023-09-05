//https://vansoft1215.tistory.com/102#google_vignette 참고
#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <stack>
using namespace std;
string str[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	stack<char> stack;
	int count = 0;
	string s;
	getline(cin, s); //getline에 대해서도 익히자.
	s += ' ';
	string result; int i = 0;
	while(i <=s.length()){
		if (s[i] == '<') {
			if (!stack.empty()) {
				while (!stack.empty()) {
					result += stack.top();
					stack.pop();
				}
				result += '<';
				i++;
			}
			while (s[i] != '>') {
				result += s[i];
				i++;
			}
			result += s[i];
			i++;
		}
		else {
			stack.push(s[i]);
			if (s[i] == ' ') {
				stack.pop();
				while (!stack.empty()) {
					result += stack.top();
					stack.pop();
				}
				result += ' ';
			}
			i++;
		}
	}
	for (int j = 0; j < s.length(); j++) {
		cout << result[j];
	}

}