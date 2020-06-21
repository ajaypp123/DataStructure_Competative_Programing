//program for add

#include<stdio.h>
#include<stdio.h>
#include<unistd.h>
#include<netdb.h>
#include<netinet/in.h>
#include<stdlib.h>
#include<arpa/inet.h>
#include<stddef.h>
#include<sys/un.h>
#include<string.h>


int main (void)
{
	int a,b,c;
	printf("Enter num:");
	scanf("%d%d",&a,&b);              //%d decimal intiger
	c=a+b;
	printf("sum=%d",c);
	printf("%s",__func__);
	return 0;
}
