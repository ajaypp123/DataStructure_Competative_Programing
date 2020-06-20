#include<stdio.h>
#include<stdarg.h>


int sum(int n, ...);

int main() {
    int p = sum(3, 10, 10, 10);
    printf("%d\n", p);
    return 0;
}

int sum(int n, ...){
    va_list arguments;
    va_start(arguments, n);
    int i;
    int s=0;
    for(i==0; i<n; i++){
        s = s + va_arg(arguments, int);
    }
    return s;
}