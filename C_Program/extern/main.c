#include<stdio.h>

int count = 3;

extern int returnCount();

int main() {
    int a = returnCount();
    printf("%d\n", a);
    return 0;
}