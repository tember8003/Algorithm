//정렬, 투포인터 문제
//제목:배열 합치기
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(static_cast<ostream*>(0));
	int* arr1;
	int* arr2;
	vector<int> b;
	vector<int>::iterator i;
	int n, m;
	cin >> n >> m;
	arr1 = (int*)malloc(sizeof(int) * n);
	arr2 = (int*)malloc(sizeof(int) * m);
	//b = (int*)malloc(sizeof(int) * (m + n));
	for (int i = 0; i < n; i++) {
		cin >> arr1[i];
		b.push_back(arr1[i]);
	}
	for (int i = 0; i < m; i++) {
		cin >> arr2[i];
		b.push_back(arr2[i]);
	}
	sort(b.begin(), b.end());
	for (i = b.begin(); i != b.end(); ++i) {
		cout << *i <<" ";
	}
	cout << endl;
	return 0;
}
