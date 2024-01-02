//이문제는 아직 이해 못함. 구글에서 검색했던걸로 기억함.
//다이나믹 프로그래밍
//제목:신나는 함수 실행
#include <iostream>
using namespace std;
int arr[21][21][21];

int w(int a, int b, int c);

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a, b, c;
	while (true)
	{
		cin >> a >> b >> c;

		if (a == -1 && b == -1 && c == -1)
			break;

		cout << "w(" << a << ", " << b << ", " << c << ") = " << w(a, b, c) << '\n';
	}
}

int w(int a, int b, int c)
{
	if (a <= 0 || b <= 0 || c <= 0)
		return 1;

	if (a > 20 || b > 20 || c > 20)
		return w(20, 20, 20);

	if (arr[a][b][c])
		return arr[a][b][c];

	if (a < b && b < c)
	{
		arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		return arr[a][b][c];
	}

	arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	return arr[a][b][c];
}
