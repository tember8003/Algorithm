#include <iostream>

using namespace std;

int Fibonacci(int num) {
    if (num == 0) return 0;
    if (num == 1) return 1;
    return Fibonacci(num - 1) + Fibonacci(num - 2);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num;
    cin >> num;

    cout << Fibonacci(num) << "\n";

    return 0;
}
