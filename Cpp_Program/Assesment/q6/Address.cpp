#include "Address.h"
#include<iostream>
#include<string>
using namespace std;

Address::Address()
{
	HouseNo = "";
        Colony = "";
        Area = "";
        City = "";
        Pincode = "";
}
	
Address::Address(string HouseNo,string Colony,string Area,string City,string Pincode)
{

	this->HouseNo = HouseNo;
        this->Colony = Colony;
        this->Area = Area;
        this->City = City;
        this->Pincode = Pincode;
}

void Address::Accept()		
{
	cout<<" Enter Your Address: \n";
	cout<<"Enter HouseNo-Colony-Area-City-Pincode : \n";
	cin>>HouseNo>>Colony>>Area>>City>>Pincode;
}

void Address::Display()
{	
	cout<<"\nDisplay User Address: \n";
	cout<<"\nHouse No : "<<HouseNo<<"\nColony: "<<Colony<<"\nArea: "<<Area<<"\nCity: "<<City<<"\nPincode: "<<Pincode<<"\n";
}

string Address::operator==(Address a1){
	if (this->HouseNo.compare(a1.HouseNo) != 0 || this->Colony.compare(a1.Colony) != 0 ||this->Area.compare(a1.Area) != 0 ||this->City.compare(a1.City) != 0 ||this->Pincode.compare(a1.Pincode) != 0){
		return "Both Address are different.";
	}else{	
		return "Both Address are Equal.";
	}	
}



