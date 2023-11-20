#include <iostream>
#include <sstream>
#include <string>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <algorithm>
#include <set>
using namespace std;
//https://headf1rst.github.io/%EC%98%A4%EB%8B%B5%EB%85%B8%ED%8A%B8/BOJ_2036/
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    vector<long long> pos, neg; 
	int num;
	int n;
	int zero = 0;
	long long result = 0;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> num;
		if (num == 0) {
			zero++;
			continue;
		}
		else if (num == 1) {
			result++;
		}
		else if (num > 0) {
			pos.push_back(num);
		}
		else {
			neg.push_back(num);
		}
	}
    sort(neg.begin(), neg.end());
    sort(pos.begin(), pos.end(), greater<int>());
    int pos_size = pos.size();
    int neg_size = neg.size();
    for(int i=0; i<neg_size - 1; i+=2)
    {
        result += neg[i] * neg[i+1];
    }
    if(neg.size() % 2 == 1 && !zero) result += neg.back();
    for(int i=0; i<pos_size - 1; i+=2)
    {
        result += pos[i] * pos[i+1];
    }
    if(pos.size() % 2 == 1) result += pos.back();
	cout << result << "\n";

}