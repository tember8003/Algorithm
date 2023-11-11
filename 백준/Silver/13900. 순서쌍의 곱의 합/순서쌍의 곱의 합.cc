#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
//그냥 brute force 로 풀면 시간초과
//https://velog.io/@xx0hn/BOJ-C-%EC%88%9C%EC%84%9C%EC%8C%8D%EC%9D%98-%EA%B3%B1%EC%9D%98-%ED%95%A9
//참고
using namespace std;
int num[100001];
long long sum[100001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long result = 0;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num[i];
		if (i == 0) {
			sum[i] = num[i];
		}
		else {
			sum[i] = sum[i - 1] + num[i];
		}
	}
	for (int i = 0; i < n-1; i++) {
		result += num[i] * (sum[n - 1] - sum[i]);
	}
	cout << result << "\n";
}