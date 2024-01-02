//정답은 이수근이야!!
//수학
#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>

using namespace std;
int cnt[6] = {2, 4, 8, 16, 32, 64};
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int a, b, c;
    int count = 0; int two_cnt = 0;
    cin >> a >> b >> c;
    for (int x = -100; x <= 100; x++) {
        if (a * x * x + b * x + c == 0) {
            count++;
            for (int i = 0; i < 6; i++) {
                if (cnt[i] == x) {
                    two_cnt++;
                }
            }
        }
    }
    if (count != 2) {
        cout << "둘다틀렸근" << "\n";
    }
    else if (two_cnt == 2) {
        cout << "이수근" << "\n";
    }
    else {
        cout << "정수근" << "\n";
    }
    return 0;
}
