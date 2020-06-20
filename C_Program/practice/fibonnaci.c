#include<conio.h>
#include<conio.h>
void main()
{
	int a=0,c,b=1,i;
	printf("\n%i\n%d",a,b);
	for(i=0;i<18;++i)
	{
		c=b;
		b+=a;
		a=c;
		printf("\n%d",a);
		
	
	}
	getch();
}
