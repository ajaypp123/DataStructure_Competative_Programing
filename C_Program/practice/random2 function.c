#include<stdio.h>
#include<conio.h>


void main ()
{
	int a;
	while(a<10)
	{
		printf("\n%d",rand()%10);
		a++;
	}
	
	getch();
}


//rand()=select random number used to selct random card game
