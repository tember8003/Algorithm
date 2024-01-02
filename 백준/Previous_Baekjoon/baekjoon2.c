
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int a, i,c;
	scanf("%d", &a);
	for (i = 1; i <=a; i++) {
		for (c = 1; c <= a - i; c++) {
			printf(" ");
		}
		for (c = 1; c <= i; c++) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
