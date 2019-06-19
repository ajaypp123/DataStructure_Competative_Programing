/* timer.c */
 
#include <stdio.h>
#include <sys/types.h>
#include <time.h>
 
int main() {  
    int i;
	time_t t1, t2;
 
    (void) time(&t1);
	
    for (i=1;i<=300;++i)
		printf("%d %d %d\n",i, i*i, i*i*i);
	
    (void) time(&t2);
	printf("\n Time to do 300 squares and cubes= %d seconds\n", (int) t2-t1);

    return 0;
}