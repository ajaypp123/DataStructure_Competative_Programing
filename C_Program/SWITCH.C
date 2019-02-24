//switch case
#include<stdio.h>
#include<conio.h>

int main ()
{
char num;
printf("Enter the char from A to G");
scanf("%c",&num);
switch (num)
{case'a':
printf("Today is Monday");
break;
case 'B':
printf("Today is Tuesday");
break;
case 'C':
printf("Today is Wednesday");
break;
case 'D':
printf("Today is Thursday");
break;
case'E':
printf("Today is Friday");
break;
case'F':
printf("Today is Saturday");
break;
case 'G':
printf("Today is Sunday");
break;
default:
printf("Please enter the number from A to G to get the output");
}
getch();
return 0;
}
