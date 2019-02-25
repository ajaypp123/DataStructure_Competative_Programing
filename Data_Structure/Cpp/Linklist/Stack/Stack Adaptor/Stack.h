#include"Linklist.h"
#include<iostream>
using namespace std;

template<class T>
class StackAdept{
	private:
		Linklist<T> ll;
	public:
		void push(T ele);
		void pop();
		T getTop();
		int size();
		bool Empty();
};


