#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

const int MAX = 50; // 최대 가로, 세로 크기
int map[MAX][MAX]; // 배추밭 지도
bool visited[MAX][MAX]; // 방문 여부
int dy[] = {0, 0, -1, 1}; // 상하좌우
int dx[] = {-1, 1, 0, 0};
int M, N, K; // 가로, 세로, 배추 개수
int ans;

void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
        int temp_x = x + dx[i];
        int temp_y = y + dy[i];

        if (temp_x >= 0 && temp_y >= 0 && temp_x < M && temp_y < N) {
            if (map[temp_x][temp_y] == 1 && !visited[temp_x][temp_y]) {
                dfs(temp_x, temp_y);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T; // 테스트 케이스 수
    cin >> T;

    while (T--) {
        cin >> M >> N >> K;

        // 초기화
        memset(map, 0, sizeof(map));
        memset(visited, false, sizeof(visited));
        ans = 0;

        for (int i = 0; i < K; i++) {
            int x, y;
            cin >> x >> y;
            map[x][y] = 1; // 배추 위치 설정
        }

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (map[j][k] == 1 && !visited[j][k]) {
                    dfs(j, k); // 새로운 영역 탐색
                    ans++;
                }
            }
        }

        cout << ans << "\n";
    }

    return 0;
}
