

#include<stdio.h>
#include<conio.h>

typedef enum
{
	summer,winter=55,cold
}season;


void year1(season s);

void main()
{
	year1(summer);
	year1(56);
	year1(0);
	year1(55);
	
}

void year1(season s)
{
	if(s==summer)
		printf("\nit hot");
	else if(s==winter)
		printf("\nit rain");
	else if(s==cold)
		printf("\nit cold");
}


