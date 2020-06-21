#include "date.h"
#define CONDITION (((temp.dd > 31) &&(temp.mm ==1 || temp.mm == 3 || temp.mm == 5 || temp.mm = 7 || temp.mm == 8 || temp.mm == 10 || temp.mm == 12)) || ((temp.dd > 30) &&(temp.mm ==4 || temp.mm == 6 || temp.mm == 9 || temp.mm = 11)) || (temp.dd > 28 && temp.mm == 2))

using namespace std;

Date::Date()
{
    this->dd=1;
    this->mm=1;
    this->yy=2000;
}

Date::Date(int dd, int mm, int yy)
{
    this->dd=dd;
    this->mm=mm;
	this->yy=yy;
}

Date::~Date()
{
    this->dd=0;
	this->mm=0;
	this->yy=0;
}

void Date::AcceptDate()
{
    Year:
    cout<<"Enter Year::";
	cin>>this->yy;
	if(this->yy < 0)
	{
        cout<<"Error: Enter positive value"<<endl;
        goto Year;
    }

	Month:
	cout<<"Enter Month(1-12)::";
	cin>>this->mm;
	if(this->mm < 1 || this->mm > 12)
	{
        cout<<"Error: Enter valid month"<<endl;
		goto Month;
    }

    bool leapYear;
    if(yy%4 == 0)
    {
        if( yy%100 == 0)
        {
            if ( yy%400 == 0)
                leapYear = true;
            else
                leapYear = false;
        }
        else
            leapYear = true;
    }
    else
        leapYear = false;

    Day:
    if(leapYear == true && this->mm==2)
    {
        cout<<"Enter day(1-29)::";
        cin>>this->dd;
        if( this->dd > 29 || this->dd <1)
        {
            cout<<"Error: Enter valid day"<<endl;
            goto Day;
        }
    }
    else if(leapYear == false && this->mm==2)
	{
        cout<<"Enter day(1-28)::";
        cin>>this->dd;
        if( this->dd > 28 || this->dd <1)
        {
            cout<<"Error: Enter valid day"<<endl;
            goto Day;
        }
    }
    else if( mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12)
    {
        cout<<"Enter day(1-31)::";
        cin>>this->dd;
        if( this->dd > 31 || this->dd <1)
        {
            cout<<"Error: Enter valid day"<<endl;
            goto Day;
        }
    }
	else
	{
        cout<<"Enter day(1-30)::";
        cin>>this->dd;
        if( this->dd > 30 || this->dd <1)
        {
            cout<<"Error: Enter valid day"<<endl;
            goto Day;
        }
    }
}

void Date::DisplayDate() const
{
    cout<<"Date: "<<this->dd<<"/"<<this->mm<<"/"<<this->yy<<endl;
}

void Date::operator==(Date d2) const
{
    if (yy == d2.yy)
    {
        if (mm == d2.mm)
        {
            if (dd == d2.dd)
            {
                cout<<"Given dates are equal"<<endl;
            }
            else
            {
                cout<<"Given dates are equal (Differ in Days)"<<endl;
            }
        }
        else
        {
            cout<<"Given dates are equal (Differ in Months)"<<endl;
        }
    }
    else
    {
        cout<<" Given dates are not equal"<<endl;
    }
}

bool Date::operator!=(const Date& d2)const
{
    if(yy != d2.yy && mm != d2.mm && dd != d2.dd)
        cout<<"Entered dates are not equal"<<endl;
    else
        cout<<"Entered dates are equal"<<endl;
}

Date Date::operator+(const int no) const
{
    Date temp = *this;
	temp.dd += no;
    do
    {
        bool leapYear;
        if(temp.yy%4 == 0)
        {
            if( temp.yy%100 == 0)
            {
                if ( temp.yy%400 == 0)
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
            temp.yy++;
            temp.mm-=12;
        }
    }while((((temp.dd > 31) &&(temp.mm ==1 || temp.mm == 3 || temp.mm == 5 || temp.mm  == 7 || temp.mm == 8 || temp.mm == 10 || temp.mm == 12)) || ((temp.dd > 30) &&(temp.mm ==4 || temp.mm == 6 || temp.mm == 9 || temp.mm == 11)) || (temp.dd > 28 && temp.mm == 2)));
    return temp;
}

Date Date::operator-(const int no) const
{
    Date temp = *this;
    temp.dd -= no;
    do
    {
        bool leapYear;
        if(temp.yy%4 == 0)
        {
            if( temp.yy%100 == 0)
            {
                if ( temp.yy%400 == 0)
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
            temp.yy--;
            temp.mm+=12;
        }
    }while(temp.dd < 1);
    return temp;
}
