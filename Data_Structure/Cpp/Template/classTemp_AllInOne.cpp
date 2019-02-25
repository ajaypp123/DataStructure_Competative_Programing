#include<iostream>
using namespace std;

template<class T, class T2>
class Array{
	private:
		T *p;
		T2 *q;
		int size;

	public:
	Array(int size){
		this->size = size;
		p = new T[this->size];
		q = new T2[this->size];
	}

	void accept(){
		T h;
		T2 h1;
		for(int i=0; i<size; i++)
		{
			p[i]= h;
		}
		
		for(int i=0; i<size; i++)
                {
                        q[i]= h1;
                }

	}
	
	void dispaly(){
		for(int i=0; i<size; i++)
                {
                        cout<<p[i]<<endl;
                }
		
		for(int i=0; i<size; i++)
                {
                        cout<<q[i]<<endl;
                }
	}
	
	~Array(){
		delete []p;
		delete []q;
	}
};

int main(){
	Array<float,int> a(5);	
	a.accept();
	a.dispaly();
	return 0;	
}


