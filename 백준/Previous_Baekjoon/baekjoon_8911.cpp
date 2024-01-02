//구현
//제목: 거북이
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#define UP 0
#define RIGHT 1
#define DOWN 2
#define LEFT 3
using namespace std;

class Turtle {
public:
	int x, y, max_x, max_y, min_x, min_y, check;
	Turtle():x(0), y(0), max_x(0), max_y(0), min_x(0), min_y(0), check(UP) {}
	void forward() {
		if (check == UP)y++;
		else if (check == RIGHT)x++;
		else if (check == DOWN) y--;
		else if (check == LEFT) x--;
	}
	void back() {
		if (check == UP)y--;
		else if (check == RIGHT)x--;
		else if (check == DOWN) y++;
		else if (check == LEFT) x++;
	}
	void moveRight() {
		if (check == LEFT) check = 0;
		else {
			check++;
		}
	}
	void moveLeft() {
		if (check == UP)check = 3;
		else {
			check--;
		}
	}
	void mcheck() {
		if (x > 0) max_x = max(x, max_x);
		if (x < 0) min_x = min(x, min_x);
		if (y > 0) max_y = max(y, max_y);
		if (y < 0)min_y = min(y, min_y);
	}
	int getSize() {
		return (max_x - min_x) * (max_y - min_y);
	}
};
int main() {
	int n;
	vector<string> arr;
	string str;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str;
		arr.push_back(str);
			str = arr[i];
			Turtle turtle = Turtle();
			for (int j = 0; j < str.size(); j++) {
				if (str[j] == 'F') {
					turtle.forward();
					turtle.mcheck();
				}
				else if (str[j] == 'B') {
					turtle.back();
					turtle.mcheck();
				}
				else if (str[j] == 'R') {
					turtle.moveRight();
				}
				else if (str[j] == 'L') {
					turtle.moveLeft();
				}
			}
			cout << turtle.getSize() << endl;
		}
	return 0;
}
