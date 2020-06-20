#include<stdio.h>
#include<conio.h>


void main ()
{
	int a;
	while(a<10)
	{
		printf("\n%i",rand(time)%10);
		a++;
	}
	
	getch();
}



