#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;

    vector<int> numbers(n);
    vector<int> answers(n);
    stack<int> stacks;

    for (int i = 0; i < n; i++) {
        cin >> numbers[i];
    }

    for (int i = n - 1; i >= 0; i--) {
        while (!stacks.empty()) {
            if (stacks.top() > numbers[i]) {
                answers[i] = stacks.top();
                break;
            } else {
                stacks.pop();
            }
        }
        if (stacks.empty()) {
            answers[i] = -1;
        }
        stacks.push(numbers[i]);
    }

    for (int i = 0; i < n; i++) {
        cout << answers[i] << " ";
    }
    cout << "\n";

    return 0;
}
