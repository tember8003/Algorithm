#include <iostream>
#include <vector>

using namespace std;

int n, s;
vector<int> arr;

int subsetSum(int num, int hap) {
    if (num == n) {
        return hap == s ? 1 : 0;
    }
    return subsetSum(num + 1, hap) + subsetSum(num + 1, hap + arr[num]);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> s;
    arr.resize(n);
    
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int result = subsetSum(0, 0);

    if (s == 0) {
        result--;
    }

    cout << result << "\n";

    return 0;
}
