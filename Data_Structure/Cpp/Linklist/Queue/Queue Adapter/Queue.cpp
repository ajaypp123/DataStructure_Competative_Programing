#include "Queue.h"

template<class T>
void Queue<T>::push(T ele){
	ll.AddEnd(ele);
}

template<class T>
void Queue<T>::pop(){	
	ll.DeleteBegin();
}

template<class T>
T Queue<T>::getFront(){
	return ll.getHead();
}

template<class T>
T Queue<T>::getRare(){
        return ll.getTail();
}

template<class T>
int Queue<T>::size(){
	return ll.size();
}

template<class T>
bool Queue<T>::Empty(){
	return ll.isEmpty();
}

template class Queue<int>;


