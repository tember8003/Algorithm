//수학
//제목:조합 0의 개수
#include <iostream>

using namespace std;

long long n, m;
long long two = 0, five = 0;
long long result = 0;
long long func(int n,int t) {
    int ans = 0;
    for (long long i = t; n / i >= 1; i *= t) {
        ans += n / i;
    }
    return ans;
}
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    if (n == m || m == 0) {
        cout << 0;
        return 0;
    }
    two = func(n, 2) - func(m, 2) - func(n - m, 2);
    five = func(n, 5) - func(m, 5) - func(n - m, 5);

    result = min(two, five);
    cout << result;

    return 0;
}
