#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int num_tests;             // 테스트 케이스 개수
    cin >> num_tests;

    for (int i = 0; i < num_tests; i++) {
        string parentheses;    // 괄호 문자열
        cin >> parentheses;

        stack<char> stk;       // 괄호를 저장할 스택
        bool is_valid = true;  // VPS 여부를 나타내는 변수

        for (int i = 0; i < parentheses.length(); i++) {
            char ch = parentheses[i];
            if (ch == '(') {
                stk.push(ch);  // 여는 괄호를 스택에 추가
            }
            else { // ch == ')'
                if (stk.empty()) {
                    is_valid = false; // 닫는 괄호가 여는 괄호보다 많음
                    break;
                }
                stk.pop(); // 여는 괄호와 짝을 이루는 닫는 괄호를 제거
            }
        }

        // 반복문 종료 후 스택이 비어 있지 않으면 여는 괄호가 남아 있음
        if (!stk.empty()) {
            is_valid = false;
        }

        // 결과 출력
        if (is_valid) {
            cout << "YES" << endl;
        }
        else {
            cout << "NO" << endl;
        }
    }

    return 0;
}
