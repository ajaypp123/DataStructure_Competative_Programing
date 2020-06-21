#include<iostream>
using namespace std;

class Student;
static void findStudent(Student *s1,int Roll);

class Student{
	private:
		int Roll;
		string Name,Course;
		
	public:
		Student(){
			Roll = 0;
		    Name = "";
			Course= "";
		}
	
		int get()
		{
			return Roll;		
		}
	
		Student(int Roll, string Name, string Course){
			this->Roll = Roll;
		    this->Name = Name;
			this->Course= Course;
		}
		
		~Student(){
			Roll = 0;
		    Name = "";
			Course= "";
		}
		
		void Accept(){
			cout<<"Enter Roll No. & Name & Course :\n";
			cin>>this->Roll>>this->Name>>this->Course;
		}
		
		void Display(){
			cout<<"\n\nRoll: "<<this->Roll<<"\nName: "<<this->Name<<"\nCourse: "<<this->Course<<endl;
		}
		
};

int main(){
	Student s[5];
	Student s1(100,"Ab","C++");
	
	cout<<"\nFor Parameterized Constructor: \n";
	s1.Display();
	
	cout<<"\nEnter five Record : \n";	
	for(int i=0; i<5; i++){
		s[i].Accept();
	}
	
	for(int j=0; j<5; j++){
		s[j].Display();
	}
	
	int Roll;
	
	cout<<"\nEnter Roll No:\n";
	cin>>Roll;
	
	for(int i=0; i<5; i++){
		findStudent( &s[i],Roll);	
	}
}

static void findStudent(Student *s1,int Roll)
{
               if(s1->get() == Roll)
                {
                  s1->Display();               
                }
}

