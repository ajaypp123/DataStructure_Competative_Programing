#include<stdio.h>
#include<stdlib.h>
#include "Linklist.h"

void initList(List* temp){
    temp->head = NULL;
    temp->tail = NULL;
    temp->count = 0;
}

void addFrist(List *li, int data){
    N *temp = (N*)malloc(sizeof(N));
    temp->data = data;
    temp->next = NULL;

    if(li->head == NULL){
        li->head = temp;
        li->tail = temp;
    }else{
        temp->next = li->head;
        li->head = temp;
    }
    li->count++;
}

void addLast(List *li, int data){
    N *temp = (N*)malloc(sizeof(N));
    temp->data = data;
    temp->next = NULL;

    if(li->tail == NULL){
        li->head = temp;
        li->tail = temp;
    }else{
        li->tail->next = temp;
        li->tail = temp;
    }
    li->count++;
}

void delFrist(List *li){
    N *temp = li->head;
    li->head = li->head->next;
    free(temp);
}

void delLast(List *li){
    N *temp = li->head;
    while(temp->next != li->tail){
        temp = temp->next;
    }
    free(li->tail);
    li->tail = temp;
    li->tail->next = NULL;
}

void Display(List *li){
    N *temp = li->head;
    while(temp != NULL){
        printf("\t%d",temp->data);
        temp = temp->next;
    }
    printf("\n");
}
