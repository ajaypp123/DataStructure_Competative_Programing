#include<stdio.h>
#include<conio.h>

struct clint
{
	char *name;
	char *email;
	int age;
} c1[];

void main()
{
	
    c1[0].name ="ajay paratmandali";
	c1[0].email ="ajaypp123\0@gmail.com";
    c1[0].age =20;
	printf("\n %s \n %s \n %d",c1[0].name,c1[0].email,c1[0].age);
	getch(); 
}
