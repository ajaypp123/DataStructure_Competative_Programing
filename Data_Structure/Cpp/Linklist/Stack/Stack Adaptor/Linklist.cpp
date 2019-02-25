#include "Linklist.h"

template<class T>
		Linklist<T>::Linklist(){
			head = NULL;
			tail = NULL;
			count = 0;
		}
		
template<class T>
		Linklist<T>::~Linklist(){
			Node<T> *temp;
			temp = head;
			while(head != NULL){
				head = head->getNext();
				delete temp;
				temp = head;
			}
		}

template<class T>
		bool Linklist<T>::isEmpty(){
			return (head == NULL && tail==NULL);
		}

template<class T>
		int Linklist<T>::size(){
			return count;
		}

template<class T>
		void Linklist<T>::AddBegin(T data){
			Node<T> *temp = new Node<T>;
			if(isEmpty()){
				temp->setNext(NULL);
				temp->setData(data);
				head = temp;
				tail = temp;	
			}else{
				temp->setNext(head);
				temp->setData(data);
				head = temp;	
			}
			count++;
		}
		
template<class T>
		void Linklist<T>::AddEnd(T data){
                        Node<T> *temp = new Node<T>;
                        if(isEmpty()){
                                temp->setNext(NULL);
                                temp->setData(data);
                                head = temp;
                                tail = temp;
                        }else{
                                tail->setNext(temp);
                                temp->setNext(NULL);
				temp->setData(data);
				tail = temp;
                        }
                        count++;
                }	
	
template<class T>
		void Linklist<T>::DeleteBegin(){
                        Node<T> *temp = new Node<T>;
                        if(isEmpty()){
				cout<<"\nList is Empty...\n";
                        }else{
				temp = head;
                                head = head->getNext();
                        }
			delete temp;
                        count--;
                }

template<class T>
		void Linklist<T>::DeleteEnd(){
                        Node<T> *n = new Node<T>;
			Node<T> *p = new Node<T>;
                        if(isEmpty()){
                                cout<<"\nList is Empty...\n";
                        }else{
                                n = head;
				while(n->getNext() != tail){
					n = n->getNext();		
				}
				p = tail;
				tail = n;
				delete p;
                                tail->setNext(NULL);
                        }
                        count--;
                }
	
template<class T>
		void Linklist<T>::Display(){
			Node<T> *temp = new Node<T>;
			if(isEmpty()){
				cout<<"\nList is Empty.";
			}else{
				temp = head;
				while(temp != NULL){
					cout<<"\n"<<temp->getData();
					temp = temp->getNext();
				}				
			}
			cout<<"\n";
		}
			
template<class T>
		void Linklist<T>::AddAtPos(int pos,T data){
			Node<T> *temp = new Node<T>;
			Node<T> *p = new Node<T>;
			Node<T> *n = new Node<T>;
			if(pos >= count+2){
				cout<<"\nWrong";
			}else{
				n = head;
				while(pos >= 2){
					p = n;
					n = n->getNext();
					pos--;	
				}
				temp->setData(data);
				temp->setNext(n);
				p->setNext(temp);
			}
			count++;
		}
		
template<class T>
		void Linklist<T>::DeleteAtPos(int pos){
                        Node<T> *p = new Node<T>;
                        Node<T> *n = new Node<T>;
                        if(pos > count){
                                cout<<"\nWrong";
                        }else{
                                n = head;
                                while(pos > 1){
                                        p = n;
                                        n = n->getNext();
                                        pos--;
                                }
                                p->setNext(n->getNext());
				delete n;
                        }
                        count--;
                }		
		
template<class T>
		T Linklist<T>::getHead(){
			return head->getData();
		}

template<class T>
		int Linklist<T>::Reverse(Node<T> *temp){
			
			if(temp->getNext() != NULL){
				Reverse(temp->getNext());
			}
			cout<<temp->getData()<<"\n";
			return 0;
		}
		

template class Linklist<int>;								
