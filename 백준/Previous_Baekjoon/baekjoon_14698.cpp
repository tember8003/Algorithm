//그리디문제
//제목:전생했더니 슬라임 연구자였던 건에 대하여 (Hard)
//참고https://dkswnkk.tistory.com/284
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
#define MAX 1000000007
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n,t;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> t;
		priority_queue<long long, vector<long long>, greater<long long>>arr;
			for (int i = 0; i < t; i++) {
				long long a;
				cin >> a;
				arr.push(a);
			}
			long long ans = 1;
			while (arr.size()>=2) {
					long long temp1 = arr.top();
					arr.pop();
					long long temp2 = arr.top();
					arr.pop();
					ans *= (((temp1 % MAX) * (temp2 % MAX)) % MAX);
					arr.push(temp1*temp2);
					ans %= MAX;
			}
			cout << ans << "\n";
		}
	
}
