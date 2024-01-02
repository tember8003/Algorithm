
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int H, M, C;
	scanf("%d %d", &H, &M);
	scanf("%d", &C);
	H += C / 60;
	M += C % 60;
	if (M >= 60) {
		M -= 60;
		H++;
	}
	if (H >= 24) {
		H -= 24;
	}
	printf("%d %d", H, M);
	return 0;
}
