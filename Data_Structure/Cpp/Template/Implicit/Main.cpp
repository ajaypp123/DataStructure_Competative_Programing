#include<iostream>
#include "Address.cpp"
using namespace std;

int main(){
	Address<string> a;
	Address<string> a1;
	Address<string> b("aa","bb","cc","dd","ee");
	b.Display();	
	cout<<"\nAddress One: \n";
	a.Accept();
	a.Display();
	cout<<"\nAddress two: \n";
	a1.Accept();
	a1.Display();
	string str = a==a1;
 	cout<<str;	
	return 0;
}
