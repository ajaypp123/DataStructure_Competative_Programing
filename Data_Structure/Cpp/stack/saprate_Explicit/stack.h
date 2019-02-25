#include<iostream>
using namespace std;

template<class T>
class Stack
{
 	private:
   		T *arr;
   		int top;
		int size;
 	public:
   	
	Stack(int size);
  	bool isfull();
  	bool isempty();
  	void push(T ele);
 	T pop();
 	T peep();
};