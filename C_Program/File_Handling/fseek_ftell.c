#include <stdio.h>
 
int main ()
{
    FILE *fp;
    fp = fopen("a.txt","w+");
    
    // Print current position
    printf("%d\n", ftell(fp));
    
    // Put line at current position
    fputs("This is tutorialspoint.com", fp);
    
    fflush(fp);

    // Move to beg of file
    fseek( fp, 7L, SEEK_SET);

    // Print current position
    printf("%d", ftell(fp));

    // Put at beg of file
    fputs(" 1. C Programming Language", fp);
    fclose(fp);
    
    return(0);
}
