#include<stdio.h>
#include<conio.h>

void main()
{
	int i=5;
	int *ip=&i;
	int **ipp=&ip;
	printf("%d",**ipp);
}
