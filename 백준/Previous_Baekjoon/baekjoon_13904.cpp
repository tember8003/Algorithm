//그리디 문제
//제목:과제
//문제 중간중간 주석은 이해하기 위해 설정한 것.
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
//https://non-stop.tistory.com/111 인용
struct Array{
	int first;
	int second;
}arr;
int compare(Array a,Array b)
{
	if (a.second == b.second) {
		return a.first > b.first;
	}
	else {
		return a.second > b.second;
	}
}
int rest[1001];
bool check[1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	Array arr[1001];
	int n;
	long long ans = 0;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i].first >> arr[i].second;
	}
	sort(arr+1 ,arr + n+1, compare);
	for (int i = 1; i <=n; i++) {
		int temp = arr[i].first;
		//cout << "처음엔" << temp << "\n";
		for (int j = temp; j >= 1; j--) {
			if (rest[j] == 0) {
				rest[j] = arr[i].second;
				//cout << rest[j] << "\n";
				break;
			}
			//cout << "break?" << "\n";
		}
	}
	for (int i = 1; i <= 1000; i++) {
		ans += rest[i];
	}
	cout << ans << "\n";
}
