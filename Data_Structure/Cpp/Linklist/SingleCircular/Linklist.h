#ifndef LINKLIST_H
#define LINKLIST_H
#include<iostream>
#include "Node.h"
using namespace std;

template<class T>
class Linklist{
	private:
		Node<T> *head;
		Node<T> *tail;
		int count;

	public:
		Linklist();
		~Linklist();
		bool isEmpty();
		int size();
		void AddBegin(T data);
		void AddEnd(T data);
		void DeleteBegin();
		void DeleteEnd();
		void Display();
		void AddAtPos(int pos,T data);
		void DeleteAtPos(int pos);
		Node<T>* getHead();							
};

#endif
