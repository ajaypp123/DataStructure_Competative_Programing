#include<stdio.h>
#include<conio.h>

typedef struct
{
	int a,b;
}fraction;

void print(fraction f);

void main()
{
	fraction p;
	p.a=5;
	p.b=4;
	
	fraction q;
	q.a=55;
	q.b=44;
	
	fraction farray[]= { p,q};
	
	for(int i=0;i<2;i++)
	print (farray[i]);
}

void print(fraction f)
{
	printf("%d/%d\n",f.a,f.b);
}
