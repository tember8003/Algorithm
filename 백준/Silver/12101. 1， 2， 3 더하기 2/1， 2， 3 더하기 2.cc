#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <set>
using namespace std;

int n, k;
vector<int> arr;
int ans = 0;
bool check = false;
void repeat(int cnt) {
	if (cnt > n) {
		return;
	}
	if (check) {
		return;
	}
	if (cnt == n) {
		ans++;
		if (ans == k) {
			for (int i = 0; i < arr.size()-1; i++) {
				cout << arr[i] << "+";
			}
			cout << arr[arr.size() - 1];
			check = true; //출력했으면 멈춤.
		}
		return;
	}
	for (int i = 1; i <= 3; i++) {
		arr.push_back(i);
		repeat(cnt + i);
		arr.pop_back();
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> k;
	repeat(0);
	if (!check) {
		cout << -1 << "\n";
	}
}