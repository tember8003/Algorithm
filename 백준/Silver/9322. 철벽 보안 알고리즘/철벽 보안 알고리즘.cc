#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int t; int n; string word;
	cin >> t;
	while (t--) {
		map<string, int> public_1;
		map<int, int> public_2;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> word;
			public_1[word] = i + 1;
		}
		for (int i = 0; i < n; i++) {
			cin >> word;
			public_2[public_1[word]] = i+1;
		}
		vector<string> password(n+1);
		for (int i = 0; i < n; i++) {
			cin >> password[i+1];
		}
		for (int i = 0; i < n; i++) {
			cout << password[public_2[i + 1]] << " ";
		}
		cout << "\n";

	}
}