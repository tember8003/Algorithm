//그래프 이론
//제목:DFS와 BFS
#include <iostream>
#include <vector>
#include <queue>
#include <string.h>
#include <algorithm>
using namespace std;

bool visited[1002];
vector<int> b_result;
vector<int> d_result;
vector <int>arr[1001];
void dfs(int start) {
    visited[start] = true;
    d_result.push_back(start);
    for (long unsigned int i = 0; i < arr[start].size(); i++) {
        if(!visited[arr[start][i]])
        dfs(arr[start][i]);
    }
}

void bfs(int start) {
    queue<int> q;
    q.push(start);
    visited[start] = true;
    while (!q.empty()) {
        int bf = q.front();
        q.pop();
        b_result.push_back(bf);
        for (long unsigned int i = 0; i < arr[bf].size(); i++) {
            int temp = arr[bf][i];
            if (!visited[temp]) {
                q.push(temp);
                visited[temp] = true;
            }
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m, v;
    cin >> n >> m >> v;
    for (int i = 1; i <= m; i++) {
        int x, y;
        cin >> x >> y;
        arr[x].push_back(y);
        arr[y].push_back(x);
    }
    
    for (int i = 1; i <= n; i++) {
        sort(arr[i].begin(), arr[i].end());
    }
    
    dfs(v);
    memset(visited, false, sizeof(visited));
    bfs(v);
    for (int i = 0; i <d_result.size(); i++) {
        cout << d_result[i] << ' ';
    }
    cout << "\n";
    for (int i = 0; i <b_result.size(); i++) {
        cout << b_result[i] << ' ';
    }
    cout << "\n";
    return 0;
}
