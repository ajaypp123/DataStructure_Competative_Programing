/*
Inline function
*/

#include<iostream>
using namespace std;

inline void display(int a) {
    cout << a;        
}

int main() {
    display(55); //function call replace by its code
    return 0;
}