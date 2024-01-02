//그리디 알고리즘,정렬
//제목:행복 유치원
#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	int num[300001];
	int dif[300001];
	for (int i = 0; i < n; i++) {
		scanf("%d", &num[i]);
	}
	for (int i = 1; i < n; i++) {
		dif[i-1] = num[i] - num[i-1];
	}

	sort(dif, dif + n-1);
	int ans = 0;
	for (int i = 0; i < n - k; i++) {
		ans += dif[i];
	}
	printf("%d\n", ans);
}
