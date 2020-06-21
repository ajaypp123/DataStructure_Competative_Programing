#include "Player.h"
#include<iostream>
#include<string>
using namespace std;

Player::Player()
{
        //Name = {""};
        Age = 0;
        Country = "";
}
	
Player::Player(string Name,int age,string Country)
{
        this->Name = Name;
        this->Age = age;
        this->Country = Country;
}

int Player::getAge(){
	return Age;
}

string Player::getName(){
	return Name;
}

void Player::Accept()		
{
	cout<<"Enter Name, Age and Country of Player \n";
	cin>>Name>>Age>>Country;
}

void Player::Display()
{	
	cout<<"\nName: "<<Name<<"\nAge: "<<Age<<"\nCountry: "<<Country<<"\n";
}

