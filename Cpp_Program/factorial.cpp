#include<iostream>
using namespace std;

int fact(int x) {
    if(x == 1) {
        return 1;
    } else if ( x == 0) {
        return 1;
    } else {
        return x * fact(x-1);
    }
}

int main() {
    int x;
    cin>>x;
    cout<<fact(x);
    return 0;
}