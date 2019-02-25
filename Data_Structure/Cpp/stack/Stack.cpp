#include<iostream>
using namespace std;
//#define SIZE 6

template<class T>
class Stack
{
 	private:
   		T *arr;
   		int top;
		int size;
 	public:
   	
	Stack(int size)
   	{
		this->size = size;
		arr = new T[size];
    		top=-1;
   	}

  	bool isfull()
  	{
   		return (top == size-1);
 	 }

  	bool isempty()
  	{
   	return top==-1;
  	}

  	void push(T ele)
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

 	T pop()
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

 
 	T peep()
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

};

int main(){
	Stack<int> st(5);
	try{
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
		st.push(10);
	}catch(char const* ss){
		cout<<ss;
	}

	try{
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
               cout<<"\npoped "<<st.pop();
        }catch(char const* ss){
                cout<<ss;
        }

	try{
               cout<<"\npeep "<<st.peep();
        }catch(char const* ss){
                cout<<ss;
        }
	
	return 0;
}
