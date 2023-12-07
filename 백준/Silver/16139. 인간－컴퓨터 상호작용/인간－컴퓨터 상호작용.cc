#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
//https://doorrock.tistory.com/53
using namespace std;
int sum[26][2001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	string str;
	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		int num = str[i] - 'a';
		sum[num][i + 1]++;
	}
	for (int i = 1; i <= str.size(); i++) {
		for (int j = 0; j < 26; j++) {
			sum[j][i] += sum[j][i - 1];
		}
	}
	int n;
	int num1, num2;
	cin >> n;
	for (int i = 0; i < n; i++) {
		char a;
		cin >> a >> num1 >> num2;
		cout << sum[a - 'a'][num2+1] - sum[a - 'a'][num1] << "\n";
	}
}