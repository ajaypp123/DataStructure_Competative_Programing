#include<iostream>
using namespace std;

int main() {
    char arr[] = "hello";
    char* ptr = "hello";
    string str = "hello";

    cout << "Print Data:\nArray: " << arr << "\nPointer: " << ptr << "\nString: " << str << endl;
    cout << "Size of:\nArray: " << sizeof(arr) << "\nPointer: " << sizeof(ptr) << "\nString: " << sizeof(str) << endl;
    return 0;
}