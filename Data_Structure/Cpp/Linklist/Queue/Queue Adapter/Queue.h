#include"Linklist.h"
#include<iostream>
using namespace std;

template<class T>
class Queue{
	private:
		Linklist<T> ll;
	public:
		void push(T ele);
		void pop();
		T getFront();
		T getRare();
		int size();
		bool Empty();
};


