#include<stdio.h>
#include<conio.h>

void address1();

void address2();

void addresschar ();

void addressfloat();


void addressarray();

void main()
{
	address1();
	address2();
	addresschar();
	addressfloat();
	addressarray();
}

void address1()
{
	int i=5;
	printf("%d \n %u \n %u \n-----------\n",&i,i,&i);
	int *q = &i;
	printf("\n %u \n %u \n-----\n",q,&i);
	//  *r = &s;     not avaible     but    int *r=&s    &    *r=s      avaible
}

void address2()
{
	int p=4;
	int *t;
	*t=p;
	printf("%u(address) \n %u(address) \n %u(value) \n-----------\n",t,&p,*t);
	
}

void addresschar ()
{
	char f= 'A';
    int *fpointer=&f;
	printf("%c(value) \n %u(address) \n-----\n" ,*fpointer, fpointer);
}

void addressfloat ()
{
	float a=8.76;
	float *f=&a;
	float k=*f;
	float *i;
	*i=a;
	printf("%f \n %f \n--------\n",k,*i);
	
}

void addressarray()
{
	int i;
	int a[]={ 5,4,3,2,1};
	for(i=0;i<5;i++)
	{
		int *p=&a[i];
		printf("\na[%d]  =  %u(address)  =  %d \n-----------\n",i,p,*p);
	}
}
