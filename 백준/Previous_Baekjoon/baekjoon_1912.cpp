//정렬
//제목 좌표 압축
#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int arr[100001];
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		if (arr[i - 1] > 0) {
			arr[i] += arr[i - 1];
		}
	}
	int result = -10001;
	for (int i = 1; i <= n; i++) {
		if (result < arr[i]) {
			result = arr[i];
		}
	}
	cout << result << "\n";
	return 0;
}
