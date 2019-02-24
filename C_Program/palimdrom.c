#include<stdio.h>

// Reverse number using recursion
int rev(num){
    int unit = 0;

    if(num == 0){
        return num;
    }
    unit = num % 10;
    return ((rev(num / 10) * 10) + unit);
}

// Return reverse number
int pal(int num){
    int unit = 0, new_num = 0;
    while(num != 0){
        unit = num % 10;
        num = num /10;
        new_num = (new_num * 10) + unit;
    }
    return new_num;
}

int main(){
    int num = 0;

    // Enter number
    printf("Enter number:\n");
    scanf("%d", &num);

    if (rev(num) == num){  //(pal(num) == num){
        printf("Palimdrome");
    }else{
        printf("Non Palamdrome");
    }

    return 0;
}

