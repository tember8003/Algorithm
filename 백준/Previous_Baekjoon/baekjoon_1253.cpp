//정렬 문제
//제목:좋다
//두포인터 이용
#include <cmath>
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

vector<long long> arr;

int main() {
    long long n, k;
    int count = 0;
    bool check = false;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> k;
        arr.push_back(k);
    }
    sort(arr.begin(),arr.end());

    for (int i = arr.size()-1; i >= 0; i--) {
        int left = 0; int right = arr.size()-1;
        if (left == i) {
            left++;
        }
        if (right == i) {
            right--;
        }
        if (left > right || right == left) {
            continue;
        }
        check = false;
        while (true) {

            if (arr[left] + arr[right] < arr[i]) {
                left++;
                if (left == i) {
                    left++;
                }
            }
            else if (arr[left] + arr[right] > arr[i]) {
                right--;
                if (right == i) {
                    right--;
                }
            }
            else if (arr[left] + arr[right] == arr[i]) {
                check = true;
                break;
            }
            if (left > right || right == left) {
                break;
            }
        }
        if (check==true) {
            count++;
        }
    }
    cout << count << "\n";

}

