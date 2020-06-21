//#ifndef DATE_H_INCLUDED
//#define DATE_H_INCLUDED
#include<iostream>
//#include<conio.h>

using namespace std;
class Date
{
private:
	int dd, mm, yy;

public:
	Date();
	Date(int dd, int mm, int yy);
	~Date();
	void AcceptDate();
	void DisplayDate() const;
	void operator==(Date d2) const;
    bool operator!=(const Date& d2)const;
	Date operator+(const int no) const;
    Date operator-(const int no) const;
};

//#endif // DATE_H_INCLUDED
