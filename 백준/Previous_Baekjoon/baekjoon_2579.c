//dp문제
//제목: 계단 오르기
//https://restudycafe.tistory.com/320 backjoon 2579
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int max(int a, int b) {
	return a > b ? a : b;
}

int main() {
	int num[302];
	int sum[302];
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &num[i]);
	}
	sum[0] = 0;
	sum[1] = num[1];
	sum[2] = num[1] + num[2];
	for (int i = 3; i <= n; i++) {
		sum[i] = max(sum[i - 3] + num[i - 1] +num[i], sum[i - 2] + num[i]);
	}
	printf("%d", sum[n]);
	return 0;
}
*/
