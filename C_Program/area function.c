#include<stdio.h>
#include<conio.h>

int area(int x,int y);

void main ()
{
	int a,b;
	printf("enter 2 num:");
	scanf("%d%d",&a,&b);
	printf("\narea=%d",area(a,b));
	getch();
}

int area (int x,int y)
{
	return x*y;
}
