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
	
		void DeleteBegin(){
                        Node *temp = new Node;
                        if(isEmpty()){
				cout<<"\nList is Empty...\n";
                        }else{
				temp = head;
                                head = head->getNext();
                        }
			delete temp;
                        count--;
                }

		void DeleteEnd(){
                        Node *n = new Node;
			Node *p = new Node;
                        if(isEmpty()){
                                cout<<"\nList is Empty...\n";
                        }else{
                                n = head;
				while(n->getNext() != tail){
					n = n->getNext();		
				}
				p = tail;
				tail = n;
				delete p;
                                tail->setNext(NULL);
                        }
                        count--;
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
			
		void AddAtPos(int pos,int data){
			Node *temp = new Node;
			Node *p = new Node;
			Node *n = new Node;
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
		
		void DeleteAtPos(int pos){
                        Node *p = new Node;
                        Node *n = new Node;
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

		int Reverse(Node *temp){
			if(temp->getNext() != NULL){
				//count1++;
				Reverse(temp->getNext());
			}
			count1++;
			cout<<temp->getData()<<"\n";
			return 0;
		}
										
};

int main(){
	Linklist ll;
	int ch = 0;
	char loop = 1;
	int data;
	int pos;
	while(loop){
		cout<<"Menu:\n1.AddBegin\n2.AddEnd\n3.DeleteBegin\n4.DeleteEnd\n5.Display\n6.Size\n7.Reverse\n8.AddAtPos\n9.DeleteAtPos\n10.Reverse List\n11.Exit\n";
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
				ll.DeleteBegin();
				cout<<"Deleted...";
				break;
			case 4:
				ll.DeleteEnd();
				break;
			case 5:
				ll.Display();
				break;
			case 6:
				cout<<ll.size()<<"\n";
				break;
			case 7:
				ll.Reverse(ll.getHead());
				break;
			case 8:
				cout<<"Enter Pos and data:\n";
				cin>>pos>>data;
				ll.AddAtPos(pos,data);
				break;
			case 9:
				cout<<"Enter Pos : \n";
				cin>>pos;
				ll.DeleteAtPos(pos);
				break;
			case 10:
				//Node *t = new Node;
				//t = 
				ll.ReverseList(ll.getHead());
				//delete t;
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
