#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	string S="";
	string temp;
	string answer = "";
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		S += temp;
	}
	int start = 0;
	int last = S.length() - 1;
	while (start <=last) {
		if (S[start] < S[last]) {
			answer += S[start];
			start++;
		}
		else if(S[start] > S[last]) {
			answer += S[last];
			last--;
		}
		else {
			int temp_1 = start + 1;
			int temp_2 = last - 1;
			bool check = false;
			while (temp_1 <= temp_2) {
				if (S[temp_1] < S[temp_2]) {
					answer += S[start];
					start++;
					check = true;
					break;
				}
				else if(S[temp_1] > S[temp_2]) {
					answer += S[last];
					last--;
					check = true;
					break;
				}
				else {
					temp_1++;
					temp_2--;
				}
			}
			if (check != true) {
				answer += S[start];
				start++;
			}
		}

	}
	for (int i = 0; i < answer.size(); i++) {
		if (i != 0 && i % 80 == 0) {
			cout << "\n";
		}
		cout << answer[i];
	}
}