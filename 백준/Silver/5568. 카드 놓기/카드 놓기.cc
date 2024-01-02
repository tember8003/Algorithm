#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <set>

using namespace std;
int n, k;
vector<int> v;
bool visited[11];
vector<int> ans;

void repeat(int cnt,string temp) {
	if (cnt == k) {
		if (find(ans.begin(),ans.end(),stoi(temp))== ans.end()) {//값이 존재하지 않는다면 ?
			ans.push_back(stoi(temp));//값 넣어주기
		}
		return;
	}
	for (int i = 0; i < n; i++) { //cnt부터 탐색하면 값이 다름.
		if (visited[i]) {
			continue;
		}
		visited[i] = true;
		repeat(cnt + 1, temp+to_string(v[i]));
		visited[i] = false;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	int num;
	cin >> n>>k;

	for (int i = 0; i < n; i++) {
		cin >> num;
		v.push_back(num);
	}
	repeat(0, "");
	cout << ans.size() << "\n";

}