#include<iostream>
#include<algorithm>
#include<vector>
#include <map>
using namespace std;

int num[1001];
int gold[1001];
int silver[1001];
int bronze[1001];
int temp = 1;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k,check;
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> check;
		cin >> gold[check] >> silver[check] >> bronze[check];
	}

	for (int i = 1; i <= n; i++) {
		if (gold[i] > gold[k]) {
			temp++;
		}
		else if (gold[i] == gold[k]) {
			if (silver[i] > silver[k]) {
				temp++;
			}
			else if (silver[i] == silver[k]) {
				if (bronze[i] > bronze[k]) {
					temp++;
				}
			}
		}

	}
	cout << temp << "\n";
}