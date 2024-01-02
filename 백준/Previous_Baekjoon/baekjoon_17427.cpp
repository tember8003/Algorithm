//수학
//제목:약수의 합2
//만약 입력값이 10이라면?
//1-> 1 / 1
//2-> 3 / 1,2
//3 -> 4 / 1,3
//4 -> 7 / 1,2,4
//5 -> 6 / 1,5
//6 -> 12 / 1,2,3,6
//7 -> 8 / 1,7
//8 -> 1,2,4,8
//9 -> 1,3,9 
//10 ->1,2,5,10 
//1*10 / 2*5 / 3*3 / 4*2 /5*2 /6*1 /7*1 / 8*1 / 9*1 / 10*1 ->규칙 성립
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long sum = 0;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		sum += i * (int)(n / i);
	}
	cout << sum << endl;
}
