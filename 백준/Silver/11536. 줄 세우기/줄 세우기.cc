#include <iostream>
#include <string.h>
#include <algorithm>
#include <queue>
#include <vector>
#include <map>

using namespace std;
vector<string> name;
vector<string> temp1;
vector<string> temp2;
bool compare(string s1, string s2) {
	return s1 > s2;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n; cin >> n;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		name.push_back(str);
	}
	for (int i = 0; i < n; i++) {
		temp1.push_back(name[i]);
		temp2.push_back(name[i]);
	}
	sort(temp1.begin(), temp1.end());
	sort(temp2.begin(), temp2.end(),compare);
	if (name == temp1) {
		cout << "INCREASING" << "\n";
	}
	else if(name==temp2) {
		cout << "DECREASING" << "\n";
	}
	else {
		cout << "NEITHER" << "\n";
	}
}