#include <iostream>
#include <string.h>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

long long dp[1001];
long long arr[1001];
long long temp = 0;
int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        dp[i] = 1;
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] < arr[j]) {
                dp[j] = max(dp[j], dp[i] + 1);
            }
        }
    }
    for (int i = 0; i < n; i++) {
        temp = max(temp, dp[i]);
    }
    cout << temp << "\n";
    return 0;
}