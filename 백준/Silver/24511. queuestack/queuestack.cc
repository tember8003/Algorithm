#include <iostream>
#include <queue>

using namespace std;

queue<int> queue_storage;      // 큐 역할을 하는 변수
bool is_stack[100000];         // 데이터가 스택에 들어가야 하는지 여부를 나타내는 배열

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;                     // 기존 데이터의 개수
    int m;                     // 새로 삽입할 데이터의 개수
    int value[100001] = {};                 // 입력값
    cin >> n;

    // 데이터가 스택에 들어가야 하는지 여부 입력
    for (int i = 0; i < n; i++) {
        cin >> is_stack[i];
    }

    // 기존 데이터 입력
    for (int i = 0; i < n; i++) {
        cin >> value[i];
    }

    //데이터 처리
    for (int i = n-1; i >= 0; i--) { //역순으로 입력받은 데이터를 처리해야 함!!
        if (!is_stack[i]) {  // 0이라면 값 넣어주기 
            queue_storage.push(value[i]);
        }
    }

    // 새 데이터 입력 +  결과 출력
    int num;
    cin >> m;

    for (int i = 0; i < m; i++) {
        cin >> num;
        queue_storage.push(num);
        cout << queue_storage.front() << " ";
        queue_storage.pop();
    }

    return 0;
}