#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> weight(N);
    vector<int> height(N);
    vector<int> rank(N, 1);

    for (int i = 0; i < N; i++) {
        cin >> weight[i] >> height[i];
    }

    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            if (weight[i] < weight[j] && height[i] < height[j]) {
                rank[i]++;
            } else if (weight[i] > weight[j] && height[i] > height[j]) {
                rank[j]++;
            }
        }
    }

    for (int i = 0; i < N; i++) {
        cout << rank[i] << " ";
    }
    cout << "\n";

    return 0;
}
