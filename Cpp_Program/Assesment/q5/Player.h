#ifndef PLAYER_H
#define PLAYER_H
#include<string>
using namespace std;

class Player{
	private:
		string Name;
		int Age;
		string Country;
	public:
		Player();
		Player(string,int,string);
		void Accept();
		void Display();
		int getAge();
		string getName();
		
};

#endif
