#include<stdio.h>
#include<unistd.h>

int main() {
    __pid_t pid = fork();
    wait();
    if(pid == 0) {
        printf("Child Process:\n     PID: %d, Parent PID: %d\n", getpid(), getppid());
    } else if(pid > 0) {
        printf("Parent Process:\n     PID: %d, Parent PID: %d\n", getpid(), getppid());
    } else {
        printf("Cannot create child process.\n");
    }
    return 0;
}