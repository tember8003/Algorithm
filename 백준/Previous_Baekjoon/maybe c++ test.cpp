//아마 예전 학교 문제였던걸로 기억함.
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;
#define MAX 5
class Lscore {
public:
	int kor;
	int eng;
};
class Rscore {
public:
	int sci;
	int math;
};
class Student {
protected:
	int num;
	char name[10];
};
class Totscore :public Student, public Lscore, public Rscore {
public:
	Totscore(int n, const char* _name, int k, int e, int m, int s) {
		num = n;
		strcpy(name, _name);
		kor = k;
		eng = e;
		math = m;
		sci = s;
	}
	void print() {
		cout << num << " " << name << " " << kor << " " << eng << " " << math << " " << sci << endl;
	}

	Totscore operator+(int k) {
		kor = kor + k;
		eng = eng + k;
		math = math + k;
		sci = sci + k;
		return *this;
	}

};
void Print(Totscore stu[]) {
	for (int i = 0; i < MAX; i++) {
		stu[i].print();
	}
}

int main() {
	Totscore st[MAX] = { Totscore(101,"KIM",85,90,80,77),Totscore(102,"Lee",90,95,89,89)
		,Totscore(103,"Park",80,70,70,55),Totscore(104,"Hong",75,80,90,85),Totscore(105,"Kang",85,90,85,85) };
	for (int i = 0; i < MAX; i++) {
		st[i] = st[i] + MAX;
	}
	Print(st);
	return 0;
}

