#include<stdio.h>
#include<conio.h>

typedef struct 
{
	int a,b;
}fraction;

void print(fraction f);

void main()
{
	fraction fra;
	fra.a=35;
	fra.b=20;
	print(fra);
}

void print(fraction f)
{
	printf("%i/%i", f.a,f.b);
}
