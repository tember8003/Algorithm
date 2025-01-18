#include <iostream>
using namespace std;

int main() {
    int max_value = 0;      // 최대값
    int max_row = 1;        // 최대값의 행 번호 (1부터 시작)
    int max_col = 1;        // 최대값의 열 번호 (1부터 시작)
    int grid[9][9];         // 9x9 격자판

    // 입력 및 최대값 탐색
    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            cin >> grid[row][col];
            if (max_value < grid[row][col]) {
                max_value = grid[row][col];
                max_row = row + 1;  // 1부터 시작하도록 조정
                max_col = col + 1;  // 1부터 시작하도록 조정
            }
        }
    }

    // 최대값과 위치 출력
    cout << max_value << endl;
    cout << max_row << " " << max_col << endl;

    return 0;
}