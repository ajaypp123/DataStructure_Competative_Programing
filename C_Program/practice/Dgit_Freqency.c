#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    char *i, *str = (char*)malloc(1024 * sizeof(char) );
    int j;
    scanf("%[^\n]", str);
    str = realloc(str, strlen(str) + 1);
    int arr[10] = {};
    for(i = str; *i; i++) {
      printf("%d\n", (int)*i);
      if ((int)*i <= 9 && (int)*i >= 0) {
        arr[(int)*i]++;
        }
    }
    // Print result
    for(j= 0; j < 10; j++) {
        printf("%d", arr[j]);
    }
    return 0 ;
}