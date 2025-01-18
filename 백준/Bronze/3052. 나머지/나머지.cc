#include <iostream>
using namespace std;

int main() {
    int arr[10];
    int unique_count = 0;

    // 배열 입력 및 나머지 계산
    for (int i = 0; i < 10; i++) {
        cin >> arr[i];
        arr[i] = arr[i] % 42;
    }

    // 중복 확인 및 개수 세기
    for (int i = 0; i < 10; i++) {
        bool is_unique = true;
        for (int j = 0; j < i; j++) {
            if (arr[i] == arr[j]) {
                is_unique = false;
                break;
            }
        }
        if (is_unique) {
            unique_count++;
        }
    }

    // 결과 출력
    cout << unique_count << endl;

    return 0;
}