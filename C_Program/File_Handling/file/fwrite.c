#include<stdio.h>
#include<conio.h>

void main()
{
	FILE *file = fopen("text.txt","w");
	fprintf(file, "ajay is cool");
	fclose(file);
	
}
