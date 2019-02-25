#include "stack.h"


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
