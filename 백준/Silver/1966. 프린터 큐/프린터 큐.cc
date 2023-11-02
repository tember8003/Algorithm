#include <iostream>
#include <queue>

using namespace std;

int main()
{
    queue<pair<int, int>> q;
    priority_queue<int> pq;
    cin.tie(NULL);
    cout.tie(NULL);
    int t; int n, m;
    int importance;
    cin >> t;
    for (int i = 0; i < t; i++) {
        int count = 0;
        cin >> n >> m;
        for (int j = 0; j < n; j++) {
            cin >> importance;
            pq.push(importance);
            q.push(make_pair(j, importance));
        }
        while (!pq.empty()) {
            int value = q.front().first;
            int import = q.front().second;
            q.pop();
            if (import == pq.top()) {
                count++;
                pq.pop();
                if (value == m) {
                    cout << count << "\n";
                    break;
                }
                else {
                    q.push(make_pair(value, import));
                }
            }
            else {
                q.push(make_pair(value, import));
            }
        }
        while (!q.empty()) {
            q.pop();
        }
        while (!pq.empty()) {
            pq.pop();
        }
    }

    return 0;
}

