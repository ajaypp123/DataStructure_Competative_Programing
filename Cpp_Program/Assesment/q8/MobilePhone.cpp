#include "MobilePhone.h"
#include<iostream>
#include<string>
using namespace std;

int MobilePhone::count = 0;

MobilePhone::MobilePhone()
{
	ModelNo[0]=0;
	Price[0]=0;
	Maf[0]="";
	Quantity[0]=0;

}
	
int MobilePhone::getModelNo(int i){
	return ModelNo[i];
}

int MobilePhone::getPrice(int i){
	return Price[i];
}

string MobilePhone::getMaf(int i){
	return Maf[i];
}

int MobilePhone::getQuantity(int i){
	return Quantity[i];
}
	
MobilePhone::MobilePhone(int ModelNo,int Price,string Maf,int Quantity)
{
	this->ModelNo[count]=ModelNo;
	this->Price[count]=Price;
	this->Maf[count]=Maf;
	this->Quantity[count]=Quantity;
}

/*		
MobilePhone::~MobilePhone()
{
	ModelNo=0;
   	Price=00;
      	Maf=" ";
      	Quantity=0;
}
*/
		
void MobilePhone::Accept()
{
	cout<<"Add Mobile to Store: ";
	cout<<"Enter ModelNo, Price, Manufacture, Quantity : \n";
	cin>>ModelNo[count]>>Price[count]>>Maf[count]>>Quantity[count];	
	count++;
}

void MobilePhone::Display()
{	
	cout<<"\nInformation of Available Mobile: \n";
	for(int i=0;i<count;i++)
	{
	   if(Quantity[i] > 0){
		cout<<"\nModel No: "<<ModelNo[i]<<"\nPrice: "<<Price[i]<<"\nManufacture: "<<Maf[i]<<"\nQuantity: "<<Quantity[i]<<"\n\n";
	   }    	
	}
	
}

void MobilePhone::Search(int ModelNo, int index, MobilePhone &mp)
{
	cout<<"\nInformation of Quantity and Availability Model NO: \n";
	for(int i=0;i<count;i++)
	{
	   if(ModelNo == index){
		cout<<"\nModel No: "<<mp.getModelNo(i)<<"\nPrice: "<<mp.getPrice(i)<<"\nManufacture: "<<mp.getMaf(i)<<"\nQuantity: "<<mp.getQuantity(i)<<"\n\n";
	   }    	
	}
}



