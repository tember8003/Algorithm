#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <map>
#include <cmath>
using namespace std;
//https://gusdnr69.tistory.com/190 참고
int n;
//map<int, int> maps;
//int arr[7];
//vector<int> v;
//vector<int> ans;

bool check_sosu(int idx) {
	for (int i = 2; i * i <= idx; i++) {
		if (idx % i == 0) {
			return false;
		}
	}
	return true;
}
void repeat(int num,int idx) {
	if (idx == n) {
		cout << num << "\n";
		return;
	}
	for (int i = 1; i <= 9; i++) {
		if (check_sosu(num * 10 + i)) {
			repeat(num * 10 + i, idx + 1);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	repeat(2, 1); repeat(3, 1); repeat(5, 1); repeat(7, 1);
}