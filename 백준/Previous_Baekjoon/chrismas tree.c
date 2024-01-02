//백준 문제는 아닌거같음 어디서 썼는지 감이 안잡힘.
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int arr[100];
int temp_arr[100];

int summary(int arr[], int N) {
    if (N == 1) return temp_arr[0];
    for (int i = 0; i < N - 1; i++) {
        temp_arr[i] = arr[i] + arr[i + 1];
    }
    summary(temp_arr, N - 1);
}

int main(void) {
    int N;
    int pcnt = 0;
    int mcnt = -1;
    int temp;
    int* ptr = &arr;

    scanf("%d", &N);
    ptr += N / 2;

    for (int i = N; i >= 1; i--) {
        if (i % 2 == 1)
            ptr[pcnt++] = i;
        else
            ptr[mcnt--] = i;
    }

    printf("top num : %d\n", summary(arr, N)); //꼭대기 숫자
    printf("sequence : "); //수열
    for (int i = 0; i < N; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
