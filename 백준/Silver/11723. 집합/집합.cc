#include <iostream>
#include <string.h>
#include <algorithm>
#include <stack>
#include <queue>
#include <vector>
#include <map>
#include <set>
#include <deque>

using namespace std;
int arr[21];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n; int num;
	string str;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str;
		if (str == "add") {
			cin >> num;
			arr[num] = 1;
		}
		else if (str == "remove") {
			cin >> num;
			arr[num] = 0;
		}
		else if (str == "check") {
			cin >> num;
			cout << arr[num] << "\n";
		}
		else if (str == "toggle") {
			cin >> num;
			if (arr[num] == 1) {
				arr[num] = 0;
			}
			else {
				arr[num] = 1;
			}
		}
		else if (str == "all") {
			for (int j = 1; j <= 20; j++) {
				arr[j] = 1;
			}
		}
		else if (str == "empty") {
			memset(arr, 0, 21*sizeof(int));
		}
	}

	
}