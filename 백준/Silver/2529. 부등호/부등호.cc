#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;
//https://gdlovehush.tistory.com/337 참고
//백트래킹 방식
int k;
char sign[11];
int num[11];
bool check[11];
vector<string> ans; //부등호 저장 벡터
string maxnum, minnum;

bool sighCheck(char a, char b, char oper) {
	if (oper == '<') {
		if (a > b) {
			return false;
		}
	}
	else {
		if (a < b) {
			return false;
		}
	}
	return true;
}

void repeat(int idx, string num) {
	if (idx == k + 1) {
		ans.push_back(num);
		return;
	}
	for (int i = 0; i < 10; i++) {
		if (check[i]) {
			continue;
		}
		if (idx == 0 || sighCheck(num[idx - 1], i + '0', sign[idx - 1])) {
			check[i] = true;
			repeat(idx + 1, num + to_string(i));
			check[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> k;
	for (int i = 0; i < k; i++) {
		cin >> sign[i];
	}
	repeat(0, "");
	sort(ans.begin(), ans.end());
	cout << ans[ans.size() - 1] << "\n";
	cout << ans[0] << "\n";
}