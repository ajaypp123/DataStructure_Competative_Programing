#include "Stack.h"
#include<iostream>
using namespace std;

int main(){
	StackAdept<int> ll;
	int ch = 0;
	char loop = 1;
	int data;
	int pos;
	while(loop){
		cout<<"Menu:\n1.push\n2.pop\n3.Get Head\n4.size\n5.Exit\n";
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
				cout<<"\nTop: "<<ll.getTop()<<endl;
				break;
		/*	case 5:
				ll.Display();
				break;
		*/	case 4:
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
		*/	case 5:
				loop = 0;
				break;
			default:
				cout<<"Enter correct choice...";
		}
	}
	return 0;
}
