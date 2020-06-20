/*
gcc linklist.h linklist.c main.c -o main
gcc -IC main.c
*/
#include<stdio.h>
#include "./list/linklist.h"

int main() {
    addLast(10);
    addLast(20);
    addLast(30);
    displayList();
    return 0;
}