#ifndef NODE_H
#define NODE_H

#include<iostream>
using namespace std;

template<class T>
class Node{
	private:
		T data;
		Node<T> *next;
		Node<T> *prev;

	public:	
		Node();
		T getData();
		void setData(T data);
		Node<T>* getNext();
		void setNext(Node<T>* temp);
		Node<T>* getPrev();
		void setPrev(Node<T>* temp);

};
#endif
	
