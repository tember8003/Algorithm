#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> stairs(n + 2, 0);
    vector<int> dp(n + 2, 0);

    for (int i = 1; i <= n; i++) {
        cin >> stairs[i];
    }

    dp[1] = stairs[1];
    dp[2] = stairs[1] + stairs[2];

    for (int i = 3; i <= n; i++) {
        dp[i] = max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i]);
    }

    cout << dp[n] << "\n";

    return 0;
}
