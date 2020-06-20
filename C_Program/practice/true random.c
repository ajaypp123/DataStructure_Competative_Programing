#include<stdio.h>



void main ()
{
	int a;
	srand(time(NULL));
	while(a<10)
	{
		printf("\n%d",rand()%10);
		a++;
	}
	
	getch();
}


//srand()=setting random 
//time(NULL)=change with time this give random number in every time we compile
