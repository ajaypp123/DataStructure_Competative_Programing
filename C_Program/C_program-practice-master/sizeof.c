#include<stdio.h>
#include<conio.h>

struct clint
{
	int age;            //int 4
	char name;       // string  8
}c;

void main()
{
	c.age=58;
	c.name="ufdhgdhklf";
	char a="fjhfjh";
	printf("%d(structure)\n %d(int) \n%d(float) \n%d(char) ",sizeof(c),sizeof(int),sizeof(float),sizeof(a));
}
