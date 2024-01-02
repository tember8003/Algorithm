//그리드 문제
//어떻게 하는지만 이해하면 어렵지 않음.
//그냥 여러 번 시도해볼 필요 있다.
//벡터 기억할 것..
//제목:신입 사원
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.first < b.first) {
		return 1;
	}
	else {
		return 0;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector <pair<int, int>> vec(100001);
	int n,t;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int sol = 0;
		cin >> t;
		for (int j = 0; j < t; j++) {
			cin >> vec[j].first >> vec[j].second;
		}
		sort(vec.begin(), vec.begin()+t, compare);
		int temp = vec[0].second;
		for (int k = 0; k < t; k++) {
			if (temp >= vec[k].second) {
				sol++;
				temp = vec[k].second;
			}
		}
		cout << sol << "\n";
	}
}
