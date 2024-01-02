//그리디 문제
//https://hegosumluxmundij.tistory.com/118 참고
//제목:통나무 건너뛰기
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;
int arr[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t,n;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int ans = 0;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		sort(arr, arr + n);
		for(int i = 0; i < n - 2; i++) {
			ans = max(ans, arr[i + 2] - arr[i]);
		}
		cout << ans << "\n";
	}

}
