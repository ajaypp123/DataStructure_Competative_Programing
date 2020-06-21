#include<iostream>
#include "Player.h"
#include<string>
using namespace std;

void sortName(Player *p, int size){
	for(int i=0;i<size-1;i++){
		for(int j=i+1;j<size;j++){
			if(p[i].getName().compare(p[j].getName()) > 0){
                                Player temp;
                                temp = p[i];
                                p[i] = p[j];
                                p[j] = temp;
                        }else if(p[i].getName().compare(p[j].getName()) == 0)
				if(p[i].getAge() > p[j].getAge()){
                                	Player temp;
                                	temp = p[i];
                                	p[i] = p[j];
                                	p[j] = temp;
                        }
		}
	}
}

/*
void sortAge(Player *p, int size){
	for(int i=0;i<size;i++){
		for(int j=0;j<size;j++){
			if(p[i].getAge() < p[j].getAge()){
				Player temp;
				temp = p[i];
				p[i] = p[j];
				p[j] = temp;
			}
		}
	}
}
*/

int main(){

	Player p[3];
	int size = 3;
	cout<<"\nSample Data : \n";
	Player p1("Sachin", 25, "India");
	p1.Display();	
	for(int i=0; i<3; i++){
	     p[i].Accept();	
	}
	
	cout<<"\n**********************\nSort by Name and Age\n";
/*	sortAge(p, size);
	
	for(int j=0; j<3; j++){
	     p[j].Display();	
	}

	cout<<"\n**********************\nSort by Name\n";
*/
	sortName(p, size);
	
	for(int k=0; k<3; k++){
	     p[k].Display();	
	}

	return 0;
}

