#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <memory.h>
#include <limits.h>

#define MIN(a,b)(a < b ? a : b)

using namespace std;

int arr[1001];
int DP[1001];

int main()
{
    int n;
    scanf("%d", &n);

    fill(DP, DP + n, INT_MAX);

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    DP[0] = 0;

    for (int i = 0; i < n; i++)
    {
        // 뛸 수있는 값
        int jump = arr[i];

        // 뛸 수있는 모든 경우
        for (int t = jump; t > 0; t--)
        {
            // 그 자리에서 뛰려할 때 그 자리에 DP값이 채워져있어야 한다.
            if (DP[i] != INT_MAX)
                DP[i + t] = MIN(DP[i] + 1, DP[i + t]);
        }
    }

    if (DP[n - 1] == INT_MAX) {
        printf("-1");
    }
    else {
        printf("%d", DP[n - 1]);
    }

    return 0;
}