//그리드 문제인데 다르게 푼 것 같음
//만약 1000까지가 아니고 100000까지였다면 틀렸을 문제.
//제목:ATM
#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;
int compare(const void* a, const void* b)
{
	const int* x = (int*)a;
	const int* y = (int*)b;

	if (*x > *y)
		return 1;
	else if (*x < *y)
		return -1;

	return 0;
}

int temp[1001];
int dp[1001];
long long hap = 0;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp[i];
	}
	qsort(temp, n, sizeof(int), compare);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			dp[i] += temp[j];
		}
		hap += dp[i];
	}
	cout << hap << "\n";
}

/* 이전 강의 보고 푼 풀이.
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

int main() {
	int a;
	int c[1001];
	int temp = 0;
	int hap = 0;
	scanf("%d", &a);
	for (int i = 0; i < a; i++) {
		scanf("%d", &c[i]);
	}
	for (int i = 0; i < a; i++) {
		for (int j = 0; j < a; j++) {
			if (c[i] < c[j]) {
				temp = c[i];
				c[i] = c[j];
				c[j ] = temp;
			}
		}
	}

	for (int k = 0; k < a; k++) {
		hap += (a - k) * c[k];
	}
	printf("%d\n", hap);
}
*/
