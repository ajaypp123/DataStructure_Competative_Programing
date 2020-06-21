#include<iostream>
#include<cstring>
#include"MyString.h"
using namespace std;

MyString::MyString(){
	this->name = NULL;
}

MyString::MyString(int size)
{
	this->name = new char[size];
}

MyString::MyString(MyString& m)
{
	this->size = m.size;
	this->name = new char[this->size];
	strcpy(name,m.name);			
}

MyString::~MyString()
{
	delete []name;	
}

void MyString::Accept(){
	cout<<"Accept String : ";
	cin>>name;
}

void MyString::Display()
{
	cout<<"Your string is: "<<this->name<<endl;
}


