#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

int main()
{
	int *num=malloc(sizeof(int)*5);
	for(int i=0;i<5;i++)
	{
		num[i]=i;
	}
	free(num);
	
}

/*
malloc function is in stdlib it is used
to allocte the mamary from special mamary called heap
hear genrally sizeof used to take int size mamary
now free() is dealloct mamary/*
