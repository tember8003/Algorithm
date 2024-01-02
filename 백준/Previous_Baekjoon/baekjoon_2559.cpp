//누적합
//제목: 수열
#include<iostream>

#include<vector>

#include<algorithm>

using namespace std;


int arr[100002];

int main()

{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n; int k;
    int result = -100000000;
    cin >> n >> k;

    for (int i = 1; i <= n; i++) {
        int temp;
        cin >> temp;
        arr[i] = arr[i - 1] + temp;


    }
    for (int i = k; i <= n; i++) {
        result = max(result, arr[i] - arr[i - k]);
    }
    cout << result << "\n";

}
