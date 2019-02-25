#include "Node.h"

template<class T>
		Node<T>::Node(){
			//data=0;
			next=NULL;
			prev=NULL;
		}

template<class T>
		T Node<T>::getData(){
			return data;
		}

template<class T>
		void Node<T>::setData(T data){
			this->data = data;
		}

template<class T>
		Node<T>* Node<T>::getNext(){
			return next;
		}

template<class T>
		void Node<T>::setNext(Node* temp){
			next = temp;
		}

template<class T>
		Node<T>* Node<T>::getPrev(){
			return prev;
		}

template<class T>
		void Node<T>::setPrev(Node* temp){
			prev = temp;
		}

template class Node<int>;
