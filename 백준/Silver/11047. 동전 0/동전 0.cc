#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);  // 동전 가치 배열

    // 동전 입력
    for (int i = 0; i < n; i++) {
        cin >> coins[i];
    }

    int num = 0;  // 사용한 동전 개수

    // 그리디 알고리즘: 큰 가치의 동전부터 사용
    for (int i = n - 1; i >= 0; i--) {
        if (coins[i] == 0 || coins[i] > k) continue;

        int mok = k / coins[i];   // 해당 동전으로 만들 수 있는 최대 개수
        k %= coins[i];            // 남은 금액 갱신
        num += mok;               // 사용한 동전 개수 누적

        if (k == 0) break;        // 금액을 정확히 만들었다면 종료
    }

    cout << num << "\n";

    return 0;
}
