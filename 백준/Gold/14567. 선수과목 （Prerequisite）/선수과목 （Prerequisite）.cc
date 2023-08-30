/*
위상 정렬 알고리즘 이용. https://m.blog.naver.com/ndb796/221236874984 참고
https://velog.io/@minayeah/C-%EB%B0%B1%EC%A4%80-14567-%EC%84%A0%EC%88%98%EA%B3%BC%EB%AA%A9-Prerequisite 참고
#include <iostream> 
#include <string.h>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;
int arr[1001];
int ans[1001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m; int a, b;
	cin >> n >> m;
	vector<vector<int>> temp(n + 1);
	queue<pair<int, int>> q;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		temp[a].push_back(b);
		arr[b]++;
	}
	for (int i = 1; i <= n; i++) {
		if (arr[i] == 0) {
			q.push({ i,1 });
		}
	}
	while (!q.empty()) {
		int cnt = q.front().first;
		int cnt2 = q.front().second;
		q.pop();
		ans[cnt] = cnt2;
		for (int i = 0; i < temp[cnt].size(); i++) {
			int come = temp[cnt][i];
			arr[come]--;
			if (arr[come] == 0) {
				q.push({come,cnt2+1});
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		cout << ans[i] << " ";
	}
}
*/
//dp방식 이용 (위상 정렬 방식도 익히면 좋을 것 같음.)
#include <iostream>
#include <string.h>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int n, m; int a, b;
	cin >> n >> m;
	vector<pair<int, int>> v;
	vector<int> dp(n + 1, 1);
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		v.push_back({ b,a });
	}
	sort(v.begin(), v.end());
	for (int i = 0; i < m; i++) {
		int past = v[i].second;
		int future = v[i].first;
		dp[future] = max(dp[future], dp[past] + 1);
	}
	for (int i = 1; i <= n; i++) {
		cout << dp[i] << " ";
	}
}