#include<iostream>
#include<cmath>
using namespace std;

class Time{
	private:
		int Hour;
		int Min;
		int Sec;
		
	public:
		Time(){
			Hour = 00;
			Min = 00;
			Sec = 00;
		}
		
		Time(int Hour, int Min, int Sec){
			(*this).Hour = Hour; 
			this->Min = Min;
			this->Sec = Sec; 
		}
		
		~Time(){
			Hour = 00;
			Min = 00;
			Sec = 00;
		}
		
		void Accept(){
			cout<<"Enter Time in Hour & Minute & Second:\n";
			cin>>this->Hour>>this->Min>>this->Sec;
		}
		
		void Display(){
			cout<<"\n\nTime : "<<this->Hour<<" : "<<this->Min<<" : "<<this->Sec<<endl;
		}	
		
		void operator>(Time t2){
		
			if(this->Hour > t2.Hour){
				cout<<"\nYour Greater Time is ";
				this->Display();
			}else if(this->Hour < t2.Hour){
				cout<<"\nYour Greater Time is ";
				t2.Display();
			}else if(this->Min > t2.Min){
				cout<<"\nYour Greater Time is ";
				this->Display();
			}else if(this->Min < t2.Min){
				cout<<"\nYour Greater Time is ";
				t2.Display();
			}else if(this->Sec > t2.Sec){
				cout<<"\nYour Greater Time is ";
				this->Display();
			}else if(this->Sec < t2.Sec){
				cout<<"\nYour Greater Time is ";
				t2.Display();
			}else{
				cout<<"\nYour Both Time are Equal";
			}
			
		}
		
		Time operator-(Time t2){
			Time temp;
			int time1,time2;
			time1 = (t2.Hour * 3600) + (t2.Min * 60) + t2.Sec;
			time2 = (this->Hour * 3600) + (this->Min * 60) + this->Sec;
			time1 = abs(time1 - time2);
			temp.Hour = time1/3600;
			temp.Min = (time1%3600)/60; 
			temp.Sec = ((time1%3600)%60);
			return temp;
		}
};

int main(){
	Time t1 , t2, t3;
	Time t4(12,00,00);
	
	cout<<"\nYour Midnight Time is : \n";
	t4.Display();
	
	cout<<"\nYour First Time : \n";
	t1.Accept();
	t1.Display();
	
	cout<<"\nYour Second Time : \n";
	t2.Accept();
	t2.Display();
	
	t1>t2;
	
	t3 = t1 - t2;    // t3 = t1.operator-(t2);  //  t3 = operator-(&t1, t2);
	
	cout<<"\nYour Time Difference is : \n";
	t3.Display();
	
}
