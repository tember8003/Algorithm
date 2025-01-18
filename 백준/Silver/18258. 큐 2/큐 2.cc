#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    queue<int> q;         // 정수를 저장하는 큐
    int num_commands;     // 명령의 개수
    string command;       // 명령어
    int value;            // push 명령어의 값

    cin >> num_commands;

    for (int i = 0; i < num_commands; i++) {
        cin >> command;

        if (command == "push") {
            cin >> value;
            q.push(value);  // 큐에 값 추가
        }
        else if (command == "pop") {
            if (!q.empty()) {
                cout << q.front() << "\n";  // 큐의 가장 앞 값을 출력
                q.pop();                    // 큐의 가장 앞 값을 제거
            }
            else {
                cout << "-1\n";             // 큐가 비어 있으면 -1 출력
            }
        }
        else if (command == "size") {
            cout << q.size() << "\n";       // 큐의 크기 출력
        }
        else if (command == "empty") {
            cout << (q.empty() ? 1 : 0) << "\n";  // 비어 있는지 확인
            /* if문보다 훨씬 간단!
              if(q.empty()){
                cout<<1<<"\n";
              } else{
                cout<<0<<"\n";
              }
            */
        }
        else if (command == "front") {
            if (!q.empty()) {
                cout << q.front() << "\n";  // 큐의 가장 앞 값을 출력
            }
            else {
                cout << "-1\n";             // 큐가 비어 있으면 -1 출력
            }
        }
        else if (command == "back") {
            if (!q.empty()) {
                cout << q.back() << "\n";   // 큐의 가장 뒤 값을 출력
            }
            else {
                cout << "-1\n";             // 큐가 비어 있으면 -1 출력
            }
        }
    }

    return 0;
}