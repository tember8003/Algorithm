#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
//https://patrick-jy.tistory.com/118 <-재귀방식이니 참고해도 좋을 것 같다.
//기본적으로 ios::sync_with_stdio(false);,cin.tie(NULL),"\n"으로 답을 써야 정답이 나오는 문제. 아니면 시간초과 나옴
using namespace std;
int n, m, temp;
struct arr {
	int point;
	string name;
};

arr arrays[100000];

arr search(int po, int left, int right) {
	int answer = 0;
	while (left <= right) {
		int mid = (left + right) / 2;
		if (po <= arrays[mid].point) {
			answer = mid;
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}
	return arrays[answer];

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
		cout << result.name << "\n";
	}
	return 0;
}
