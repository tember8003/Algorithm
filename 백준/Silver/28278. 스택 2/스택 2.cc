#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    stack<int> stk;          // 정수를 저장하는 스택
    int num_commands;        // 명령의 개수
    cin >> num_commands;

    while (num_commands--) {
        string command;      // 명령어
        cin >> command;

        if (command == "1") {
            int value;       // 스택에 넣을 값
            cin >> value;
            stk.push(value);
        } else if (command == "2") {
            if (!stk.empty()) {
                cout << stk.top() << "\n";
                stk.pop();
            } else {
                cout << -1 << "\n";
            }
        } else if (command == "3") {
            cout << stk.size() << "\n";
        } else if (command == "4") {
            cout << (stk.empty() ? 1 : 0) << "\n";
        } else if (command == "5") {
            if (!stk.empty()) {
                cout << stk.top() << "\n";
            } else {
                cout << -1 << "\n";
            }
        }
    }

    return 0;
}
