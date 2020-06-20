#ifndef LINKLIST_H
#define LINKLIST_H

typedef struct Node {
    int data;
    struct Node *next;

}node;

typedef struct linklist {
    node *head;
    node *tail;
}list;

int isEmpty();
void addLast(int);
void displayList();

#endif