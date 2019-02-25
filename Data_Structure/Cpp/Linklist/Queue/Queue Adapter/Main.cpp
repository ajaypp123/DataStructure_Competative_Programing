#include "Queue.h"
#include<iostream>
using namespace std;

int main(){
	Queue<int> ll;
	int ch = 0;
	char loop = 1;
	int data;
	int pos;
	while(loop){
		cout<<"Menu:\n1.push-Back\n2.pop-Front\n3.Get Front\n4.Get Rare\n5.size\n6.Exit\n";
		cin>>ch;
		switch(ch){
			case 1:
				cout<<"Enter Element : \n";
				cin>>data;
				ll.push(data);
				break;
			case 2:
				ll.pop();
				cout<<"Deleted...";
				break;
			case 3:
				cout<<"\nFront: "<<ll.getFront()<<endl;
				break;
		/*	case 5:
				ll.Display();
				break;
		*/	case 4:
				cout<<"Rare: "<<ll.getRare()<<endl;
				break;
			case 5:
				cout<<ll.size()<<"\n";
				break;
		/*	case 7:
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
		*/	case 6:
				loop = 0;
				break;
			default:
				cout<<"Enter correct choice...";
		}
	}
	return 0;
}
