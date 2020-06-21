#include<iostream>
#include "MobilePhone.h"
using namespace std;

int main(){
	int ch(0);
	int record(0);
	int ModelNo(0);
	MobilePhone mp;
	
	while(1){
	    cout<<"\nMenu: \n1.Add Mobile \n2.Display \n3.Search Quantity And Availabity of Model \n4.Exit.\n";
	    cin>>ch;

	    switch(ch)
	    {
		case 1:
			mp.Accept();
			record++;
			break;			
		case 2:
			mp.Display();
			break;
		case 3:
			cout<<"\nEnter Model No:";
			cin>>ModelNo;
			for(int i=0;i<record;i++){ 
			     MobilePhone::Search(ModelNo,mp.getModelNo(i),mp);
			}
			break;
		case 4:
			return 0;
		default:
			cout<<"\nEnter correct choise";	
	    }
	}
}
