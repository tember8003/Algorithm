#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> prices(n + 1, 0); 
    vector<int> dp(n + 1, 0);

    for (int i = 1; i <= n; i++) {
        cin >> prices[i];
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i] = max(dp[i], dp[i - j] + prices[j]);
        }
    }

    cout << dp[n] << "\n";

    return 0;
}
