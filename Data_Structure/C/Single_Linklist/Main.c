#include<stdio.h>
#include<stdlib.h>
#include "Linklist.h"

int main(){
    // Initialize list
    int data;
    List li;
    initList(&li);

    int ch=1;
    while(ch != 0){
        printf("Menu:\n1. AddFrist\n2. AddLast\n3. DelFirst\n4. DelLast\n5. Display\n0. Exit\n");
        scanf("%d",&ch);
        switch(ch){
            case 1:
                printf("Enter data:\n");
                scanf("%d", &data);
                addFrist(&li, data);
                break;
            case 2:
                printf("Enter data:\n");
                scanf("%d", &data);
                addLast(&li, data);
                break;
            case 3:
                delFrist(&li);
                break;
            case 4:
                delLast(&li);
                break;
            case 5:
                Display(&li);
                break;
            case 0:
                break;
            default:
                printf("Enter correct choice");
        }
    }

    return 0;
}

