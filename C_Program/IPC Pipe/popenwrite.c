#include <stdio.h>

int main() {
    int i = 0;

    // Write
    FILE *fpw = popen("cat", "w");
    
    for(i=0;i<10;i++) {
        fprintf(fpw, "Count = %d\n", i);
    }
    fputs("Data is printed by cat.\n", fpw);

    pclose(fpw);
    return 0;
}