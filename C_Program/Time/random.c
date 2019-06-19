/* random.c */
#include <stdio.h>
#include <sys/types.h>
#include <time.h>
 
int main() { 
    int i;
	time_t t1;
	(void) time(&t1);

    // set unique seed 
    srand48((long) t1);

    // Print random number
    for (i=0;i<5;++i)
		printf("%d ", lrand48());

    return 0;
}