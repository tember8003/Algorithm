//수학
//제목: 나머지
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int a[10];
	int c = 0;

	for (int i = 0; i < 10; i++) {
		scanf("%d", &a[i]);
		a[i] = a[i] % 42;
	}
	for (int k = 0; k < 10; k++) {
		int b = 0;
		for (int j = k + 1; j < 10; j++) {
			if (a[k] == a[j]) {
				++b;
			}
		}
			if (b == 0) {
				++c;
			}
		
	}
	printf("%d\n", c);
}
