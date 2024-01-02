//수학
//제목:골드바흐의 추측
#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
//https://subbak2.com/m/164 참고
//왜 내껀 안돌아가는지 모르겠음.
//내가 문제인건지 문제가 이상한건지 감이 안옴...

using namespace std;
#define MAX 1000000
bool check[MAX+1];

int main() {

	int n,left,right;

	for (int i = 2; i*i < 1001; i++)
	{
		if (check[i] == false)
			for (int j = i * i; j < MAX; j += i)
			{
				check[j] = true;
			}
	}
	while(1){
		scanf("%d", &n);
		if (n == 0) {
			break;
		}
		left = 3;
		right = n - 3;
		while (left <= right) {
			if (check[left] == 0 && check[right] == 0) {
				break;
			}
			left += 2;
			right -= 2;
		}
		if (left > right) {
			printf("Goldbach's conjecture is wrong.\n");
		}
		else {
			printf("%d = %d + %d\n", n, left, right);
		}
	}
	return 0;
}
