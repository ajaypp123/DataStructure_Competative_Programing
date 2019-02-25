#include "Address.h"
#include<iostream>
#include<string>
using namespace std;

template<class T>
Address<T>::Address()
{
	HouseNo = "";
        Colony = "";
        Area = "";
        City = "";
        Pincode = "";
}
	
template<class T>
Address<T>::Address(T HouseNo,T Colony,T Area,T City,T Pincode)
{

	this->HouseNo = HouseNo;
        this->Colony = Colony;
        this->Area = Area;
        this->City = City;
        this->Pincode = Pincode;
}

template<class T>
void Address<T>::Accept()		
{
	cout<<" Enter Your Address: \n";
	cout<<"Enter HouseNo-Colony-Area-City-Pincode : \n";
	cin>>HouseNo>>Colony>>Area>>City>>Pincode;
}

template<class T>
void Address<T>::Display()
{	
	cout<<"\nDisplay User Address: \n";
	cout<<"\nHouse No : "<<HouseNo<<"\nColony: "<<Colony<<"\nArea: "<<Area<<"\nCity: "<<City<<"\nPincode: "<<Pincode<<"\n";
}

template<class T>
T Address<T>::operator==(Address a1){
	if (this->HouseNo.compare(a1.HouseNo) != 0 || this->Colony.compare(a1.Colony) != 0 ||this->Area.compare(a1.Area) != 0 ||this->City.compare(a1.City) != 0 ||this->Pincode.compare(a1.Pincode) != 0){
		return "Both Address are different.";
	}else{	
		return "Both Address are Equal.";
	}	
}

//template class Address<string>;



