#include<stdio.h>

// Define array size max 10
struct stack {
    int size;
    int stk[10];
    int top;
};

// Display stack
void display(struct stack st){
    int i;
    for(i = 0; i <= st.top; i++ ){
        printf("\t%d", st.stk[i]);
    }
}

// Check stack is empty
int isEmpty(struct stack *st){
    return (st->top == -1)?1:0;
}

// Check stack is Full
int isFull(struct stack *st){
    return (st->top == (st->size-1))?1:0;
}

// Push element in stack
void push(struct stack *st, int num){
    if(!isFull(st)){
        st->top++;
        st->stk[st->top] = num;
    }else{
        printf("Stack is Full");
    }
}

// Pop element from stack
void pop(struct stack *st){
    if(!isEmpty(st)){
        st->top--;
    }else{
        printf("Stack is Empty");
    }
}

int main() {
    int ch = 1, num, size=0;
    printf("Enter size of stack: ");
    scanf("%d", &size);
    
    // Initialize stack
    struct stack st;
    st.size = size;
    st.top = -1;

    while(ch != 0){
        printf("\nSelect option: 1.Push 2.Pop 3.Display 0.Exit: ");
        scanf("%d", &ch);
        // Switch case
        switch(ch){
            case 1:
                printf("\nEnter Num: ");
                scanf("%d", &num);
                push(&st, num);
                break;
            case 2:
                pop(&st);
                break;
            case 3:
                display(st);
                break;
            default:
                printf("\nEnter correct choise");
        }
    }

    return 0;
}
