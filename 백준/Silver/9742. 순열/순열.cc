#include <iostream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>

using namespace std;
int factorial(int num)
{
	int result = 1;
	for (int i = 1; i <= num; ++i)
	{
		result = result * i;
	}
	return result;
}
int arr[21];
int temp[21];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	string str;
	while (true) {
		int count = 1;
		char arr[11];
		char temp[11];
		cin >> str;
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str[i];
		}
		cin >> n;
		if (cin.eof()) {
			break;
		}
		long long fac = factorial(str.length());
		if (fac < n) {
			cout << str<< " " <<n<< " = No permutation";
		}
		else {
			cout << str << " " << n << " = ";
			do {
				if (count == n) {
					for (int i = 0; i < str.length(); i++) {
						cout << arr[i];
					}
					break;
				}
				count++;
			} while (next_permutation(arr, arr + str.length()));
		}
		cout << "\n";
	}
}