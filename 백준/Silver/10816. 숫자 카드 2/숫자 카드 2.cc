#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    int N,T;
	cin >> N;
	vector<int> temp(N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &temp[i]);
	}
	sort(temp.begin(), temp.end());
	cin >> N;
	vector<int> end(N);
	for (int i = 0; i < N; i++) {
		cin >> T;
		auto up = upper_bound(temp.begin(), temp.end(), T);
		auto low = lower_bound(temp.begin(), temp.end(), T);
		//upper_bound,lower_bound 알고리즘에 대해 공부하면 이해할 수 있다.
		//쉽게 upper_bound는 배열에서 T값보다 큰 인덱스 번호를 가져오고 lower_bound는 배열에서 T값보다 작은 인덱스 번호를 가져온다.
		//그 차이를 빼면 갯수를 알 수 있을 것이다. (대신 먼저 정렬을 해줘야한다.)
		//예) -10 -10 2 3 3 6 7 10 10 10이 정렬된 값.
		//upper_bound는 가장 큰 인덱스 번호인 9를 가져올 것이고,lower_bound는 6을 가져올 것이다 -> 빼면 3개
		end[i] = up - low;
	}
	for (auto n : end) {
		cout << n << " ";
	}
	return 0;

}
