#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

int main() {
	int c[10] = { 0, };
	int hap = 0;
	int same1 = 0; int same2 = 0;
	int temp = 0;
	for (int i = 0; i < 9; i++) {
		scanf("%d", &c[i]);
		hap += c[i];
	}
	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8 - i; j++) {
			if (c[j] > c[j + 1]) {
				temp = c[j];
				c[j] = c[j + 1];
				c[j + 1] = temp;
			}
		}
	}
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (i == j)
				continue;
			if (hap - c[i] - c[j] == 100) {
				same1 = i;
				same2 = j;
				break;
			}
		}
	}
	for (int k = 0; k < 9; k++) {
		if (k == same1 || k == same2) {
			continue;
		}
		else {
			printf("%d\n", c[k]);
		}
	}
}