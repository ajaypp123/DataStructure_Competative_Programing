#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

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
