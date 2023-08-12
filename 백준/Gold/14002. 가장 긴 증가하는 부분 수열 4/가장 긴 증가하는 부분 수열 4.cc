#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int arr[1002];
int dp[1002];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        dp[i] = 1;
    }
    if (n == 1) {
        cout << 1 << "\n";        
        cout << arr[0];
    }
    else {

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        int temp = -1;
        vector<int> v;
        for (int i = 0; i < n; i++) {
            temp = max(temp, dp[i]);
        }
        cout << temp << "\n";
        int k = temp;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == k) {
                v.push_back(arr[i]);
                k--;
            }
            if (k == 0) {
                break;
            }
        }
        int size = v.size();
        for (int i = 0; i < size; i++) {
            cout << v.back() << "\n";
            v.pop_back();
        }
    }

    return 0;

}