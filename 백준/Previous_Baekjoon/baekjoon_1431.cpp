//정렬
//제목:시리얼 번호
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int strplus(string a) {
	int n;
	n = a.length();
	int sum = 0;
	for (int i = 0; i < n; i++) {
		if (a[i]-'0' >=0 && a[i]-'0' <= 9) {
			sum += a[i]-'0';
		}
	}
	return sum;
}
bool compare(string a, string b) {
	if (a.length() != b.length()) {
		return a.length() < b.length();
	}
	else {
		int a_plus = strplus(a);
		int b_plus = strplus(b);
		if (a_plus != b_plus) {
			return a_plus < b_plus;
		}
		else {
			return a < b;
		}
	}
}
int main() {
	int n;
	cin >> n;
	vector<string> arr;
	vector<string>::iterator ai;
	string str;
	for (int i = 0; i < n; i++) {
		cin >> str;
		arr.push_back(str);
	}
	sort(arr.begin(), arr.end(), compare);
	for (ai = arr.begin(); ai != arr.end(); ai++) {
		cout << *ai << endl;
	}
	return 0;
}
