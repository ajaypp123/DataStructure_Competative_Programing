#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node *next;
    int data;
};

struct Linklist{
    struct Node *head;
    struct Node *tail;
    int count;
};

// typedef
typedef struct Node N;
typedef struct Linklist List;

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
