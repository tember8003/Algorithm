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
long long arr[100005];
//https://www.singun11.wtf/posts/boj-14427-2/

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue < pair<long long, long long>, vector<pair<long long, long long>>, greater<pair<long, long>>> pq;
	int n;
	cin >> n;
	for (long long i = 0; i < n; i++) {
		cin >> arr[i];
		pq.push({arr[i],i});
	}
	int m; int temp;
	int num1; int num2;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> temp;
		if (temp == 2) {
			while (!pq.empty() && arr[pq.top().second] != pq.top().first) {
				pq.pop();
			}
			cout << pq.top().second+1 << "\n";
		}
		else {
			cin >> num1;
			cin >> num2;
			num1--;
			arr[num1] = num2;
			pq.push({ num2,num1 });
		}
	}


}