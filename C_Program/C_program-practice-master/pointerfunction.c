#include<stdio.h>
#include<conio.h>


void fun(int *i);

void main ()
{
	int p=5;
	fun(&p);
	printf("%d",p);
	
}

void fun(int *i)
{
	*i=0;
}
