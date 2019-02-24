#include<stdio.h>
#include<conio.h>

struct clint
{
	char a;
	int b;
};

int main()
{
	typedef unsigned long long ull;
	ull a=5;
	printf("%llu",a);
	
	typedef struct clint clint;
	clint c;
	c.a ='d';
	c.b =5;
	printf("%c%d",c.a,c.b);
	
}
