#ifndef MOBILEPHONE_H
#define MOBILEPHONE_H
#include<string>
using namespace std;

class MobilePhone{
	private:
		int ModelNo[100];
		int Price[100];
		string Maf[100];
		int Quantity[100];
		static int count; 
		
	public:
		MobilePhone();
		MobilePhone(int,int,string,int);
	//	~MobilePhone();
		void Accept();
		void Display();
		static void Search(int,int,MobilePhone &mp);
		int getModelNo(int i);
		int getPrice(int i);
		string getMaf(int i);
		int getQuantity(int i);	
};

#endif
