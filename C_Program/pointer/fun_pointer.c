#include<stdio.h>

int sum(int a, int b) {
    return a+b;
}

int main() {
    int (*fp)(int, int);
    fp = sum;
    int p = fp(10,10);
    printf("%d\n", p);
    return 0;
}