#include <iostream>
#include <sstream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>
using namespace std;
//https://howudong.tistory.com/228 참고
//처음 그냥 완전탐색 쓰려고 했음->실패
//구글링 중 풀이가 가장 이해가 잘되서 씀.
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	vector<int> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i];
	}
	vector<int> result;
	result.push_back(v[0]);

	for (int i = 1; i < v.size(); i++) {
		bool check = false;
		for (int j = 0; j < result.size(); j++) {
			if (result[j] - 1 == v[i]) {
				result[j]--;
				check = true;
				break;
			}
		}
		if (!check) {
			result.push_back(v[i]);
		}
	}
	cout << result.size() << "\n";

}