//큐
//제목 큐2
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
using namespace std;
#define MAXDATA 2000002;
//#include <queue>
//queue<int>q;
template <class T>
class Queue {
public:
	int m_size;
	int frist;
	int last;
	int count;
	T* arr;
	Queue() {
		m_size = MAXDATA;
		frist = 0;
		last = 0;
		count = 0;
		arr = new T[m_size];
	}
	~Queue() {
		delete[] arr;
	}
	void push(T n) {
		if (!isFull()) {
			arr[last] = n;
			last = (last + 1) % m_size;
			count++;
		}
	}
	void pop() {
		if (!empty()) {
			cout << arr[frist] << "\n";
			frist = (frist + 1) % m_size;
			count--;
		}
		else {
			cout << "-1" << "\n";
		}
	}
	bool empty() {
		if (count == 0) {
			return true;
		}
		else
			return false;
	}
	int size() {
		return count;
	}
	int front(){
		if (!empty()) {
			return arr[frist];
		}
		else {
			return -1;
		}
	}
	int back(){
		if (!empty()) {
			return arr[last-1];
		}
		else {
			return -1;
		}
	}

	bool isFull() {
		if ((last + 1) % m_size == frist) {
			return true;
		}
		else {
			return false;
		}
	}
};
int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	Queue<int> q;
	int n,temp;
	string str;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str;
		if (str == "push") {
			cin >> temp;
			q.push(temp);
		}
		else if (str == "front") {
			cout << q.front() << "\n";
		}
		else if (str == "back") {
			cout << q.back() << "\n";
		}
		else if (str == "size") {
			cout << q.size() << "\n";
		}
		else if (str == "empty") {
			cout << q.empty() << "\n";
		}
		else if (str == "pop") {
			q.pop();
		}
	}
}
