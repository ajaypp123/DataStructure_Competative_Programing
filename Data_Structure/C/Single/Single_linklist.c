#include<stdio.h>
#include<stdlib.h>

typedef struct Node {
    int data;
    struct Node *next;
}Node;

typedef struct List {
    Node *head;
    Node *tail;
    int count;
}List;

void init_list(List* li) {
    li->head = NULL;
    li->tail = NULL;
    li->count = 0;
}

void display(List* li) {
    Node *temp = li->head;
    printf("\nDisplay List:\n");

    while(temp != NULL) {
        printf("\t%d", temp->data);
        temp = temp->next;
    }
    printf("\nTotal Count: %d\n", li->count);
}

void add_first(List* li, int val) {
    Node *new = (Node*)malloc(sizeof(Node));
    new->data = val;
    new->next = NULL;

    if(li->head == NULL || li->tail == NULL) {
        li->head = new;
        li->tail = new;
    }else {
        new->next = li->head;
        li->head = new;
    }
    li->count++;
}

int main() {
    List li;
    init_list(&li);

    int ch = 1, val;
    while(ch != 0) {
        printf("\nSelect Menu:\n1. Display \n2. Add First\n");
        scanf("%d", &ch);
        switch(ch) {
            case 1:
                display(&li);
                break;
            case 2:
                printf("Enter value: ");
                scanf("%d", &val);
                add_first(&li, val);
                break;
            default:
                printf("Enter correct choice: ");
                break;
        }
    }
    return 0;
}