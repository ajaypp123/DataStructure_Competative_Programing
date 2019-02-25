#include "stack.h"

template<class T>
Stack<T>::Stack(int size)
   	{
		this->size = size;
		arr = new T[size];
    		top=-1;
   	}

template<class T>
  	bool Stack<T>::isfull()
  	{
   		return (top == size-1);
 	 }

template<class T>
  	bool Stack<T>::isempty()
  	{
   	return top==-1;
  	}

template<class T>
  	void Stack<T>::push(T ele)
  	{
    		if(!isfull())
    		{  
     			top++;
     			arr[top]=ele;
    		}else
		{
			throw "overflow\n";
		}
   	}

template<class T>
 	T Stack<T>::pop()
  	{
   		if(!isempty())
   		{
    			T ele=arr[top];
    			top--;
  			return ele;
   		}
   		else
   		{
    			throw "Stack underflow\n";
   		}
  	}

 
template<class T>
 	T Stack<T>::peep()
 	{
  		if(!isempty())
   		{
    			T ele=arr[top];
			return ele;
   		}
   		else{
			throw "underflow\n";
		}

 	}


template class Stack<int>;
