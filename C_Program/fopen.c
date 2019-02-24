#include<stdio.h>
#include<conio.h>

void main()
{
	FILE *file = fopen("c.txt","r");
	char c;
	do
	{
		c=fgetc(file);
		printf("%c",c);
		     
	}
	while(c != EOF);
	
	printf("\n--------\n");
	
	fclose(file);
	
}
