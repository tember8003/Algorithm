#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, temp;
    priority_queue<int> q;
    
    cin >> n;
    while (n--) {
        cin >> temp;
        if (temp == 0) {
            if (q.empty()) {
                cout << -1 << "\n";
            } else {
                cout << q.top() << "\n";
                q.pop();
            }
        } else {
            while (temp--) {
                int num;
                cin >> num;
                q.push(num);
            }
        }
    }

    return 0;
}
