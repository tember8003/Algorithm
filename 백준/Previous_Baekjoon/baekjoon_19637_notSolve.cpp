#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
//https://patrick-jy.tistory.com/118 근데 왜 내가 틀린거지?
using namespace std;
int n, m, temp;
struct arr {
	int point;
	string name;
};

arr arrays[100000];

arr search(int po, int left, int right) {
	if (left <= right) {
		int mid = (left + right) / 2;
		if (po <= arrays[mid].point) {
			return search(po, left, mid - 1);
		}
		else {
			return search(po, mid + 1, right);
		}
	}
	else {
		return arrays[left];
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> arrays[i].name >> arrays[i].point;
	}
	for (int i = 0; i < m; i++) {
		cin >> temp;
		arr result = search(temp, 0, n - 1);
		cout << result.name << endl;
	}
	return 0;
}
