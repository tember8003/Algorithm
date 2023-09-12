#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>

using namespace std;
int temp1[10001]; int temp2[10001];
vector<int> str;
int sum = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string str1, str2, cnt;
	cin >> str1 >> str2;
	if (str1.size() < str2.size()) {
		cnt = str1;
		str1 = str2;
		str2 = cnt;
	}
	for (int i = 0; i < str1.size(); i++) {
		temp1[i+1] = str1[i] - '0';
	}
	for (int i = 0; i < str2.size(); i++) {
		temp2[i + 1 + (str1.size() - str2.size())] = str2[i] - '0';
	}
	for (int i = str1.size(); i > 0; i--) {
		sum = temp1[i] + temp2[i];
		if (sum >= 10) {
			temp1[i - 1]++;
			sum -= 10;
		}
		str.push_back(sum);
	}
	if (temp1[0] != 0) {
		cout << 1;
	}
	for (int i = str.size() - 1; i >= 0; i--) {
			cout << str[i];
		}
	
}