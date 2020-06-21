#include<iostream>
#include<cmath>
using namespace std;

//int mon[] = {31,28,31,30,31,30,31,31,30,31,30,31};

class Date{
	private:
		int dd;
		int mm;
		int yyyy;
		int flag;
		
	public:
		Date(){
			dd = 00;
            mm=00;
            yyyy=0000;
			flag = 0;
		}
		
		Date(int dd, int mm, int yyyy){
			this->dd = dd; 
			this->mm= mm;
			this->yyyy = yyyy; 
			cout<<"Date format is "<<this->dd<<"/"<<this->mm<<"/"<<this->yyyy<<endl;
		}
		
		void Accept(){
			cout<<"Enter Date in dd & mm & yyyy: \n";
			cin>>this->dd>>this->mm>>this->yyyy;
		}
		
		void Display(){
			cout<<"\n\nDate : "<<this->dd<<" / "<<this->mm<<" / "<<this->yyyy<<endl;
		}	
		
		void operator>(Date t2){
		
			if(this->yyyy > t2.yyyy){
				flag = 1;		
			}else if(this->yyyy < t2.yyyy){
				flag = 2;
			}else if(this->mm > t2.mm){
				flag = 1;		
			}else if(this->mm < t2.mm){
				flag = 2;
			}else if(this->dd > t2.dd){
				flag = 1;		
			}else if(this->dd < t2.dd){
				flag = 2;
			}else{
				cout<<"\nYour Both Date are Equal";
				flag = 1;
			}
			
		}
		
		int operator==(Date t2){
		
			if(this->yyyy == t2.yyyy && this->mm == t2.mm &&  this->dd == t2.dd){
				return 1;//cout<<"\nYour Both Date are Equal";
			}else{
				return 0;
			}	
		}
		
		int operator!=(Date t2){
		
			if(this->yyyy != t2.yyyy || this->mm != t2.mm ||  this->dd != t2.dd){
				return 1;//cout<<"\nYour Both Date are Equal";
			}else{
				return 0;
			}
			
		}
		
		
		Date operator+(const int no) const
		{
    		Date temp = *this;
			temp.dd += no;
    		do
    		{
        		bool leapYear;
        		if(temp.yyyy%4 == 0)
        		{
            		if( temp.yyyy%100 == 0)
            		{
                		if ( temp.yyyy%400 == 0)
                    		leapYear = true;
                		else
                    		leapYear = false;
            		}
            		else
                		leapYear = true;
        		}
        		else
            		leapYear = false;

        		if(leapYear && temp.mm == 2 && temp.dd > 29)
        		{
            		temp.mm++;
            		temp.dd-=29;
        		}
        		else
        		{
            		if(temp.mm == 2 && temp.dd > 28)
           		 	{
                		temp.mm++;
                		temp.dd-=28;
            		}
            		else if(temp.mm == 4 || temp.mm == 6 || temp.mm == 9 || temp.mm == 11)
            		{
                		if(temp.dd > 30)
                		{
                    		temp.mm++;
                    		temp.dd-=30;
                		}
            		}
            		else  if(temp.mm == 1 || temp.mm == 3 || temp.mm == 5 || temp.mm == 7 || temp.mm == 8 || temp.mm == 10 || temp.mm == 12)
            		{
                		if(temp.dd>31)
                		{
                    		temp.mm++;
                    		temp.dd-=31;
                		}
            		}
        		}

        		if(temp.mm > 12)
        		{
            		temp.yyyy++;
            		temp.mm-=12;
        		}
    		}while((((temp.dd > 31) &&(temp.mm ==1 || temp.mm == 3 || temp.mm == 5 || temp.mm  == 7 || temp.mm == 8 || temp.mm == 10 || temp.mm == 12)) || ((temp.dd > 30) &&(temp.mm ==4 || temp.mm == 6 || temp.mm == 9 || temp.mm == 11)) || (temp.dd > 28 && temp.mm == 2)));
    		return temp;
		}

		int getFlag(){
			return flag;
		}
	
	Date operator-(int no){
	Date temp = *this;
    temp.dd -= no;
    do
    {
        bool leapYear;
        if(temp.yyyy%4 == 0)
        {
            if( temp.yyyy%100 == 0)
            {
                if ( temp.yyyy%400 == 0)
                    leapYear = true;
                else
                    leapYear = false;
            }
            else
                leapYear = true;
        }
        else
            leapYear = false;

        if(leapYear && temp.mm == 2 && temp.dd < 1)
        {
            temp.mm--;
            temp.dd+=29;
        }
        else
        {
            if(temp.mm == 2 && temp.dd < 1)
            {
                temp.mm--;
                temp.dd+=28;
            }
            else if(temp.mm == 4 || temp.mm == 6 || temp.mm == 9 || temp.mm == 11)
            {
                if(temp.dd < 1)
                {
                    temp.mm--;
                    temp.dd+=30;
                }
            }
            else  if(temp.mm == 3)
            {
                if(temp.dd < 1)
                {
                    temp.mm--;
                    if(leapYear)
                        temp.dd+=29;
                    else
                        temp.dd+=28;
                }
            }
            else  if(temp.mm == 1 || temp.mm == 5 || temp.mm == 7 || temp.mm == 8 || temp.mm == 10 || temp.mm == 12)
            {
                if(temp.dd < 1)
                {
                    temp.mm--;
                    temp.dd+=31;
                }
            }
        }
        if(temp.mm < 1)
        {
            temp.yyyy--;
            temp.mm+=12;
        }
    }while(temp.dd < 1);
    return temp;
    }
    
    void operator<(Date t2){
    	int count = 0;
    	while(1){
    	if(t2 == *this){
    		cout<<"\nYour Both Date Difference : "<<count;	
    		break;
		}else{
			*this = *this + 1;
			count++;
		}
	}
    }
};

int main(){
	Date d1 ,d2,d3;
    cout<<"Date Format : "<<endl;
	Date d4(00,00,0000);
	d4.Display();
	
	cout<<"\nYour First Date : \n";
	d1.Accept();
	d1.Display();
	
	cout<<"\nYour Second Date : \n";
	d2.Accept();
	d2.Display();
	//overload == and !=
	if(d1 == d2){
		cout<<"\nYour Both Date are Equal";
		d3 = d1; 
		d1 = d2;	
	}else if(d1 != d2){
		cout<<"\nYour Both Date are Not Equal";
		d1>d2;
		if(1 == d1.getFlag()){
			d3 = d1; 
			d1 = d2;	
		}else{
			d3 = d2;
			d1 = d1;
		}
		cout<<"\n lower date : ";
		d1.Display();
		cout<<"\n higher date : ";
		d3.Display();
	}
	//overload +
	int no;
	cout<<"Enter No For next day : \n";
	cin>>no;
	d2 = d1 + no;
	d2.Display();
	//overload -
	cout<<"Enter No For prev day : \n";
	cin>>no;
	d2 = d1 - no;
	d2.Display();
	//difference
	d1<d3;
	
	return 0;	
}
