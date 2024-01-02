#define _CRT_SECURE_NO_WARNINGS
#include <algorithm>
#include <iostream>
#include <cmath>
using namespace std;
bool twoN(int num) {
	return (num & (num - 1)) == 0;
}
int main() {
	int a, b, c;
	cin >> a >> b >> c;
	long long result1;
	long long result2;
	if (pow(b, 2) - 4 * a * c <= 0) {
		printf("둘다틀렸근\n");
	}
	else {
		result1 = (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
		result2 = (-b - sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
		if (twoN(result1) && twoN(result2)) {
			printf("이수근\n");
		}
		else {
			printf("정수근\n");
		}
	}
}
//당연히 맞다고 생각했는데, 의외로 틀린 문제... 여러 검색도 해보았지만 답을 못찾음; 근데 굉장히 쉬운 문제라고 생각함
