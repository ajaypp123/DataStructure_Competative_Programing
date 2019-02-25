#ifndef NODE_H
#define NODE_H

#include<iostream>
using namespace std;

template<class T>
class Node{
	private:
		T data;
		Node<T> *next;

	public:	
		Node();
		T getData();
		void setData(T data);
		Node<T>* getNext();
		void setNext(Node<T>* temp);

};
#endif
	
