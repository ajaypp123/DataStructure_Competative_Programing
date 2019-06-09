#include<iostream>
#include<sstream>
using namespace std;

int main() {
    string output;
    stringstream ss;

    int age = 30;

    ss << "Age ";
    ss << age;

    output = ss.str();
    cout << output;
    return 0;
}