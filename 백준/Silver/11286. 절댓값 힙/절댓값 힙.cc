#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
struct cmp {
	bool operator()(int a, int b) { //abs는 절댓값
		if (abs(a) == abs(b)) {
			return a > b;
		}
		else {
			return abs(a) > abs(b);
		}
	}
};

int main() { 
    //기본적으로 최대 힙, 최소 힙과 동일한 코드 하지만 비교 함수를 추가해 해결하는 문제!
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    
    priority_queue<int,vector<int>, cmp> pq;
	int N,x;
	cin >> N;
    
	for (int i = 0; i < N; i++) {
		cin >> x;
		if (x == 0) {
			if (!pq.empty()) {
				cout << pq.top() << "\n";
				pq.pop();
			}
			else {
				cout << 0 << "\n";
			}
		}
		else {
			pq.push(x);
		}
	}
    
    return 0;
}