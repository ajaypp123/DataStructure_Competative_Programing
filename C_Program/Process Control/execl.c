#include<stdio.h>
#include<unistd.h>

int main() {
    printf("List of file in current Dir:\n");
    execl("/usr/bin/ls", "ls", "-l", 0);
    return 0;
}