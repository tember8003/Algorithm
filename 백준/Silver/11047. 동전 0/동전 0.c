#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main() {
	int mok = 0;
	int maybe = 1000000;
	int num = 0;
	int n, k;
	int c[11] = { 0, };
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d", &c[i]);
		if (c[i] > k)
			c[i] = 0;
	}

	while (n--) {
		if (c[n] == 0) {
			continue;
		}
		else {
			mok = k / c[n];
			k = k % c[n];
			num += mok;
		}
		if (k % c[n] == 0)
			break;
	}
	printf("%d\n", num);

}