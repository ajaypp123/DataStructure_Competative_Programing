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
			while(head != tail){
				head = head->getNext();
				delete temp;
				temp = head;
			}
			delete tail;
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
				temp->setNext(temp);
				temp->setData(data);
				head = temp;
				tail = temp;	
			}else{
				temp->setNext(head);
				temp->setData(data);
				head = temp;
				tail->setNext(head);	
			}
			count++;
		}
		
template<class T>
		void Linklist<T>::AddEnd(T data){
                        Node<T> *temp = new Node<T>;
                        if(isEmpty()){
                                temp->setNext(temp);
				temp->setData(data);
				head = temp;
				tail = temp;
                        }else{
                                tail->setNext(temp);
                                temp->setNext(head);
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
                        }else if(head == head->getNext()){
				head = NULL;
				tail = NULL;
			}else{
				temp = head;
                                head = head->getNext();
				tail->setNext(head);
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
                        }else if(head == head->getNext()){
				head = NULL;
				tail = NULL;
			}else{
                                n = head;
				while(n->getNext() != tail){
					n = n->getNext();		
				}
				p = tail;
				tail = n;
				delete p;
                                tail->setNext(head);
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
				do{
					cout<<"\n"<<temp->getData();
					temp = temp->getNext();
				}while(head != temp);				
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
		Node<T>* Linklist<T>::getHead(){
			return head;
		}


template class Linklist<int>;								
