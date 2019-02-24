#include<stdio.h>
#include<conio.h>

typedef union
{
	int a;
	char b;
}myu;

typedef union
{
	char *a;
	char *b;
}u;

void main ()
{
	myu p;
	p.a=0;
	p.b=4;
	printf("%d",p.a);
	
	u q;
	q.a= "ajay";
	q.b= "paratmandali";
	printf("\n %s",q.a);
}

/*  UNION is like structure store larger bit of deta type 
               for myu int is larger 4 bit deta type first these 4bit take by p.a then p.b
               thus it print 4 insted of 0.
               
               for u first store address of a then these address taken by b.
 */              
