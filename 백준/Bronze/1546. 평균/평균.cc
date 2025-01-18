#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int a;
	float b[1000];
	float same = 0, well = 0;
	float weel = 0,c=0;
	scanf("%d", &a);
	for (int i = 0; i < a; i++) {
		scanf("%f", &b[i]);
		if (b[i] > same) {
			same = b[i];
		}
	}
	//printf("최대:%f\n", same);
	for (int j = 0; j < a; j++) {
		c = (b[j] * 100 / same);
		well += c;
	}
	weel = well / a;
	printf("%f\n", weel);
}