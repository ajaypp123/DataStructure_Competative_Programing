#include<iostream>
using namespace std;

class Node{
	private:
		int data;
		Node *next;

	public:	
		Node(){
			data=0;
			next=NULL;
		}

		int getData(){
			return data;
		}

		void setData(int data){
			this->data = data;
		}

		Node* getNext(){
			return next;
		}

		void setNext(Node* temp){
			next = temp;
		}

};

class Linklist{
	private:
		Node *head;
		Node *tail;
		int count;
		int count1;	

	public:
		Linklist(){
			head = NULL;
			tail = NULL;
			count = 0;
			count1 = 0;
		}
		
		~Linklist(){
			Node *temp;
			temp = head;
			while(head != NULL){
				head = head->getNext();
				delete temp;
				temp = head;
			}
		}

		bool isEmpty(){
			return (head == NULL && tail==NULL);
		}
		int size(){
			return count;
		}
		
		void AddEnd(int data){
                        Node *temp = new Node;
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
	
		void Display(){
			Node *temp = new Node;
			if(isEmpty()){
				cout<<"\nList is Empty.";
			}else{
				temp = head;
				while(temp != NULL){
					cout<<"\n"<<temp->getData();
					temp = temp->getNext();
				}				
			}
			cout<<"\ncount1 : "<<count1<<endl;
		}
		
		Node* getHead(){
			return head;
		}	

		Node* ReverseList(Node *temp ){
			if(temp->getNext() != NULL){
				Node *t2 = new Node;
				t2 = ReverseList(temp->getNext());
				t2->setNext(temp);
			}
			if(temp == head){
				temp->setNext(NULL);
				Node *t = new Node;
				t = tail;
				tail = head;
				head = t;
			}
			return temp;
                }

										
};

int main(){
	Linklist ll;
	int ch = 0;
	char loop = 1;
	int data;
	int pos;
	while(loop){
		cout<<"Menu:\n2.AddEnd\n5.Display\n10.Reverse List\n11.Exit\n";
		cin>>ch;
		switch(ch){
			case 2:
				cout<<"Enter Element : \n";
				cin>>data;
				ll.AddEnd(data);
				break;
			case 5:
				ll.Display();
				break;
			case 10: 
				ll.ReverseList(ll.getHead());
				break;
			case 11:
				loop = 0;
				break;
			default:
				cout<<"Enter correct choice...";
		}
	}
	return 0;
}
