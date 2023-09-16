#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>
#include <deque>

using namespace std;
//https://programforlife.tistory.com/53 참고
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	cin >> n;
	long long answer = 0;
	stack<int> stack;
	for (int i = 0; i < n; i++) {
		int h;
		cin >> h;
		if (stack.empty()) {
			stack.push(h);
			continue;
		}
		while (!stack.empty() && stack.top() <= h) {
			stack.pop();
		}
		answer += stack.size();
		stack.push(h);
	}
	cout << answer << "\n";
}