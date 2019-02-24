#include <stdio.h>
#include "stack.h"

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
