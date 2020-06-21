#include "date.h"

using namespace std;

enum ops {EXIT, ACCEPT_DATE, DISPLAY_DATE, COMPARE_DATES, DIFFERENCE_IN_DATES,
            ADD_DAYS, SUBSTRACT_DATES};

int MenuFunction()
{
	int choice;
	cout<<"1. Accept Date"<<endl;
	cout<<"2. Display Date"<<endl;
	cout<<"3. Compare Dates"<<endl;
	cout<<"4. Difference between dates"<<endl;
	cout<<"5. Add Days"<<endl;
	cout<<"6. Substract Days"<<endl;
	cout<<"0. Exit"<<endl;
	cout<<"Enter your choice::";
	cin>>choice;
	return choice;
}

int main()
{
	Date d1,d2;
	int choice, no;

	while((choice=MenuFunction())!=0)
	{
		switch(choice)
		{
		case ACCEPT_DATE:
			d1.AcceptDate();
		break;

		case DISPLAY_DATE:
			d1.DisplayDate();
		break;

		case COMPARE_DATES:
			cout<<"Enter first date::"<<endl;
			d1.AcceptDate();
			cout<<"Enter second date::"<<endl;
            d2.AcceptDate();
			d1.operator==(d2);
		break;

		case DIFFERENCE_IN_DATES:
/*			cout<<"Enter first date::"<<endl;
			d1.AcceptDate();
			cout<<"Enter second date::"<<endl;
            d2.AcceptDate();
			d2.operator-(d1); */
		break;

		case SUBSTRACT_DATES:
            d1.AcceptDate();
            cout<<"Enter no of days to subtract::";
            cin>>no;
            d2 = d1 - no;
            d2.DisplayDate();
            break;

		case ADD_DAYS:
            d1.AcceptDate();
            cout<<"Enter no of days to add::";
            cin>>no;
            d2 = d1 + no;
            d2.DisplayDate();
            break;
		}
	}
	return 0;
}
