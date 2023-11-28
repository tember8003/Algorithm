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
bool check[1001] = { false };
//https://kmooc.udemy.com/course/comgong_codingtest/learn/lecture/29145890#notes
//유데미 강의 참고
int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	int n, l;
	int num;
	cin >> n >> l;
	for (int i = 0; i < n; i++) {
		cin >> num;
		check[num] = true;
	}
	int x = 0;
	int answer = 0;
	while (x < 1001) {
		if (check[x] == true) {
			answer += 1;
			x += l;
		}
		else {
			x += 1;
		}
	}
	cout << answer << "\n";
}