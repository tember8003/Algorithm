
#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
	queue<int> q;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}
	while(q.size()>1){
		q.pop();
		int top = q.front();
		q.pop();
		q.push(top);
	}
	cout << q.front() << "\n";
}
