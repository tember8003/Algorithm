#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int MAX_HEALTH = 99;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> hp(n + 1);      // 체력 손실 배열
    vector<int> happy(n + 1);   // 기쁨 배열

    // 입력 받기: 체력
    for (int i = 1; i <= n; i++) {
        cin >> hp[i];
    }

    // 입력 받기: 기쁨
    for (int i = 1; i <= n; i++) {
        cin >> happy[i];
    }

    // dp[i][j]: i번째 사람까지 고려했을 때, 체력 j로 얻을 수 있는 최대 기쁨
    vector<vector<int>> dp(n + 1, vector<int>(MAX_HEALTH + 1, 0));

    // DP 수행
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= MAX_HEALTH; j++) {
            if (hp[i] > j) {
                // i번째 사람을 선택하지 않는 경우
                dp[i][j] = dp[i - 1][j];
            } else {
                // i번째 사람을 선택하거나 선택하지 않는 경우 중 최대값 선택
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - hp[i]] + happy[i]);
            }
        }
    }

    cout << dp[n][MAX_HEALTH] << "\n";

    return 0;
}
