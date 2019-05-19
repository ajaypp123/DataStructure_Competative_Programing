/*
Print each word of the sentence in a new line.

Sample Input 0
This is C 

Sample Output 0
This
is
C
*/

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    char *s;
    s = malloc(1024 * sizeof(char));
    scanf("%[^\n]", s);
    s = realloc(s, strlen(s) + 1);
    //Write your logic to print the tokens of the sentence here.
    for(char* i = s; *i; i++) {
        if(*i == ' ') {
            printf("\n");
        }else {
            printf("%c", *i);
        }
    }
    return 0;
}