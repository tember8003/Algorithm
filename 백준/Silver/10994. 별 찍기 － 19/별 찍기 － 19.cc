#include <iostream>
#include <vector>

using namespace std;

vector<vector<char>> star; //char형 2차원 배열

void drawStar(int n, int idx) {
    if (n <= 0) return; // 종료 조건

    int size = 4 * n - 3;
    for (int i = idx; i < idx + size; i++) {
        star[idx][i] = '*';
        star[idx + size - 1][i] = '*';
        star[i][idx] = '*';
        star[i][idx + size - 1] = '*';
    }

    drawStar(n - 1, idx + 2);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    int size = 4 * N - 3;

    // 2D 벡터를 공백(' ')으로 초기화
    star.assign(size, vector<char>(size, ' '));

    if (N == 1) {
        cout << "*\n";
        return 0;
    }

    drawStar(N, 0);

    // 결과 출력
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            cout << star[i][j];
        }
        cout << "\n";
    }

    return 0;
}
