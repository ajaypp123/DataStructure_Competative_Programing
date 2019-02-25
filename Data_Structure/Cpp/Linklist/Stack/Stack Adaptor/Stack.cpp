#include "Stack.h"

template<class T>
void StackAdept<T>::push(T ele){
	ll.AddBegin(ele);
}

template<class T>
void StackAdept<T>::pop(){	
	ll.DeleteBegin();
}

template<class T>
T StackAdept<T>::getTop(){
	return ll.getHead();
}

template<class T>
int StackAdept<T>::size(){
	return ll.size();
}

template<class T>
bool StackAdept<T>::Empty(){
	return ll.isEmpty();
}

template class StackAdept<int>;


