
// Define array size max 10
struct stack {
    int size;
    int stk[10];
    int top;
};

// Display stack
void display(struct stack st);

// Check stack is empty
int isEmpty(struct stack *st);

// Check stack is Full
int isFull(struct stack *st);

// Push element in stack
void push(struct stack *st, int num);

// Pop element from stack
void pop(struct stack *st);

