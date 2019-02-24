#include<stdio.h>
#include<conio.h>

void binary();

void octol();

void hexadecimal();

void main()
{
    binary();
    octol();
    hexadecimal();
	
}

void binary()
{
	int  b = 0b101;
	printf("%d\n------------\n ",b);
}

void octol()
{
	int a = 0345, b =393;
	printf("%d\n%o\n-------------\n",a,b);
	
}

void hexadecimal()
{
	int a = 0xA56B, b = 365;
	printf(" %d \n %x \n %X",a,b,b);
	
}
