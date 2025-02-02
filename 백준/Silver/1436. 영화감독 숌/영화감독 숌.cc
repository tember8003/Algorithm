#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;

    cin >> N;

    int num = 0;
    int count = 0;
    int last = 0;

    while (num != N) {
        count++;
        last = count;
        while (last != 0) {
            if (last % 1000 == 666) {
                num++;
                break;
            } else {
                last /= 10;
            }
        }
    }

    cout << count << "\n";

    return 0;
}
