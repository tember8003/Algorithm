//long 당해버린 문제 처음에 long long으로 안써서 틀림 ㅎ;
//그리디 문제인..가? (우선순위 큐 써서 품)
//제목:카드 합체 놀이
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue<long long,vector<long long>,greater<long long>> arr;
	int n, m, k;
	long long temp = 0;
	long long ans = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> k;
		arr.push(k);
	}
	for (int i = 0; i < m; i++) {
		temp = 0;
		temp += arr.top();
		arr.pop();
		temp += arr.top();
		arr.pop();
		arr.push(temp);
		arr.push(temp);
	}
	for (int i = 0; i < n; i++) {
		ans += arr.top();
		arr.pop();
	}
	cout << ans << "\n";
}
