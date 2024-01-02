//수학
//제목: 숫자의 개수
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int a, b, c,d,e;
	int arr[10] = { 0, };
	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);
	d = a * b * c;
	while (d > 0) {
		e = d % 10;
		arr[e]++;
		d = d / 10;
	}
	for (int i = 0; i <= 9; i++) {
		printf("%d\n", arr[i]);
	}
	return 0;

}
