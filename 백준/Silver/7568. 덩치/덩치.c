#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
	int n;
	int a[101];
	int b[101];
	int c[101]={0,};
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &a[i], &b[i]);
		c[i] = 1;
	}
	for (int i = 0; i < n; i++) {
		for (int j = i+1; j < n; j++) {
			if (a[i] < a[j] && b[i] < b[j]) {
				c[i]++;
			}
			else if (a[i] > a[j] && b[i] > b[j]) {
				c[j]++;
			}
		}
	}
	for (int i = 0; i < n; i++) {
		printf("%d ", c[i]);
	}
	return 0;
}