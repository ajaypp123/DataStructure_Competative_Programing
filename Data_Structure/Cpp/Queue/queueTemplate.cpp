#include<iostream>
using namespace std;

template<class T>
class Queue{
	private:
		T *p;
		int front;
		int rare;
		int size;
	public:
		Queue(int size){
			this->size = size;
			p = new T[size];
			front = -1;
			rare = -1;
		}
			
		~Queue(){
			delete []p;
                }
		
		bool isFull(){
			if(rare == size-1){
				return true;
			}else{
				return false;
			}
		}

		bool isEmpty(){
			if(rare == front){
                                return true;
                        }else{  
                                return false;
                        }
		}

		void Add(T val){
			if(!isFull()){
				rare++;
				p[rare]=val;
			}else{
				throw "Overflow..";
			}	
		}

		void Delete(){
			if(!isEmpty()){
				front++;
			}else{
				throw "Underflow..";
			}
		}

		void Display(){
			front++;
			for(int i=front; i<=rare; i++){
				cout<<p[i]<<endl;
			}
		}
};

int main(){
	Queue<int> q(10);
	try{
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
		q.Add(11);
	}catch(char const* ss){
		cout<<ss;
	}	
	
	q.Display();

	try{
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
                q.Delete();
        }catch(char const* ss){
                cout<<ss;
        }
		
	return 0;	
}

