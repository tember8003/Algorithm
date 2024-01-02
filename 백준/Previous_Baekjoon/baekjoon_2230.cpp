//정렬 문제
//제목:수 고르기
//두 포인터 이용
//https://velog.io/@e7838752/BOJ2230 참고
/* 내가 작성했던 코드.
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

vector<long long> arr;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m,k;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> k;
		arr.push_back(k);
	}
	sort(arr.begin(), arr.end());
	int left = 0; int right = arr.size() - 1;
	long long ans = arr[right] - arr[left];
	while (true) {
		if (arr[right] - arr[left] < m) {
			right--;
		}
		else if (arr[right] - arr[left] > m) {
			if (ans > arr[right] - arr[left]) {
				ans = arr[right] - arr[left];
			}
			left++;
		}
		else if (arr[right] - arr[left] == m) {
			ans = m;
			break;
		}
		if (left >= right) {
			break;
		}
		if (left > n || right < 0) {
			break;
		}
	}
	cout << ans << "\n";
}
*/

//정답
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define INF 2000000000
using namespace std;

vector<long long> arr;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m,k;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> k;
		arr.push_back(k);
	}
	sort(arr.begin(), arr.end());
	int left = 0; int right = 0;
	long long ans = INF;
	while (left < n && right<n) {
		long long result = arr[right] - arr[left];
		if (result < m) {
			right++;
		}
		else  {
			ans = min(ans, result);
			left++;
		}
	}
	cout << ans << "\n";
}
