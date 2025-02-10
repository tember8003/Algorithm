#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

vector<int> dx = {-1, -1, -1, 0, 0, 1, 1, 1};
vector<int> dy = {-1, 0, 1, -1, 1, -1, 0, 1};

void dfs(int x, int y, vector<vector<int>>& map, vector<vector<bool>>& visited, int h, int w) {
    visited[x][y] = true;
    for (int i = 0; i < 8; i++) {
        int temp_x = x + dx[i];
        int temp_y = y + dy[i];
        if (temp_x < 0 || temp_y < 0 || temp_x >= h || temp_y >= w) continue;
        if (map[temp_x][temp_y] == 1 && !visited[temp_x][temp_y]) {
            dfs(temp_x, temp_y, map, visited, h, w);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    while (true) {
        int w, h;
        cin >> w >> h;
        if (w == 0 && h == 0) break;

        vector<vector<int>> map(h, vector<int>(w));
        vector<vector<bool>> visited(h, vector<bool>(w, false));

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> map[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j, map, visited, h, w);
                    result++;
                }
            }
        }

        cout << result << "\n";
    }

    return 0;
}
