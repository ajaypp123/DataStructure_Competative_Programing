#ifndef ADDRESS_H
#define ADDRESS_H
#include<string>
using namespace std;

template<class T>
class Address{
	private:
		T HouseNo;
		T Colony;
		T Area;
		T City;
		T Pincode;		
	public:
		Address();
		Address(T,T,T,T,T);
		void Accept();
		void Display();
		T operator==(Address);
};

#endif
