#include <stdio.h>

int main() {
    FILE *fp;
    char path[1000];

    fp = popen("ls *", "r");
    if (fp == NULL) {
        printf("Error");
    }

    while(fgets(path, 1000, fp) != NULL) {
        printf("%s", path);
    }
    
    pclose(fp);
    return 0;
}