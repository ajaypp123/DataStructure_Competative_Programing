#include<stdio.h>
#include<stdlib.h>
#include "linklist.h"

list li;

int isEmpty() {
    return li.head==NULL && li.tail==NULL;
}

void addLast(int data) {
    node* temp = (node*)malloc(sizeof(node));
    temp->data = data;
    temp->next = NULL;
    if(isEmpty()) {
        li.head = temp;
        li.tail = temp;
    } else {
        li.tail->next = temp;
        li.tail = temp;
    }
}

void displayList() {
    node *temp = li.head;
    while(temp != NULL){
        printf("%d\n", temp->data);
        temp = temp->next;
    }
}