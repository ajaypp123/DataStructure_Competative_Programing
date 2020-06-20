#include<stdio.h>
#include<conio.h>

void error(char massage[],int amount);
void main()
{
	error("enter correct num",3);
}

void error(char massage[],int ammount)
{
	for(int i=0;i<ammount;i++)
	{
     	printf("error %s\n",massage);
    }
}

