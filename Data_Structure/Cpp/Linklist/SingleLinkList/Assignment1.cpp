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

		void AddBegin(int data){
			Node *temp = new Node;
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
		
		void AddConsacative(){
			Node *t = new Node;
			int sum = 0;
			t = head;

			while(t != NULL && t->getNext() != NULL){
				sum = t->getData();
				t = t->getNext();
				sum = sum + t->getData();
				Node *n = new Node;
				//t=NULL;
				n->setData(sum);
				n->setNext(t->getNext());
				t->setNext(n);
				t = n->getNext();
				sum = 0;
				//Display();
			}			
		}
		
		void Even(){
			int pos = 1;
			Node *t = new Node;
			t = head;

			while(t != NULL){
				if(pos%2 == 0){
					cout<<"\t"<<t->getData();
				}
				t = t->getNext();
				pos++;
			}
			cout<<"\n";			
		}
		
		void AddEven(){
			Node *temp = new Node;
			temp = head;
			int sum = 0;
			
			while(temp != NULL && temp->getNext() !-= NULL){
				temp = temp->getNext();
				if(temp != NULL){
					sum = temp->getData();
					temp = temp->getNext();
					if(temp != NULL){
						temp = temp->getNext();
						if(temp != NULL){
							sum = sum + temp->getData();
							AddBegin(sum);
						}
					}
				}
				if(temp != NULL){
							temp = temp->getNext();
				}
			}		
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
			cout<<endl;
		}
		
		Node* getHead(){
			return head;
		}	
								
};

int main(){
	Linklist ll;
	int ch = 0;
	char loop = 1;
	int data;
	int pos;
	while(loop){
		cout<<"Menu:\n1.AddBegin\n2.AddEnd\n3.Add consacative and add result after it\n4.Display Even Node\n5.Display\n6.Add Even Node and add result at begin\n11.Exit\n";
		cin>>ch;
		switch(ch){
			case 1:
				cout<<"Enter Element : \n";
				cin>>data;
				ll.AddBegin(data);
				break;
			case 2:
				cout<<"Enter Element : \n";
				cin>>data;
				ll.AddEnd(data);
				break;
			case 3:
				ll.AddConsacative();
				break;
			case 4:
				ll.Even();
				break;
			case 6:
				ll.AddEven();
				break;
			case 5:
				ll.Display();
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
