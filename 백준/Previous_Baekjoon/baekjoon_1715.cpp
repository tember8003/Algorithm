//그리디 알고리즘
//제목:카드 정렬하기
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

priority_queue<int, vector<int>, greater<int>> arr;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n,k;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> k;
		arr.push(k);
	}
	int hap = 0;
	if (n == 1) {
		cout << 0 << "\n";
	}
	else if (n == 2) {
		hap = arr.top();
		arr.pop();
		hap += arr.top();
		cout << hap << "\n";
	}
	else {
		while (arr.size()>1) {
			int sov1 = arr.top();
			arr.pop();
			int sov2 = arr.top();
			arr.pop();
			hap += sov1 + sov2;
			arr.push(sov1 + sov2);
		}
		cout << hap << "\n";
	}
	
}
