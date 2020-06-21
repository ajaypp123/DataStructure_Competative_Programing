#ifndef ADDRESS_H
#define ADDRESS_H
#include<string>
using namespace std;

class Address{
	private:
		string HouseNo;
		string Colony;
		string Area;
		string City;
		string Pincode;		
	public:
		Address();
		Address(string,string,string,string,string);
		void Accept();
		void Display();
		string operator==(Address);
};

#endif
