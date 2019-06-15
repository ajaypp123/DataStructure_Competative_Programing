#include<iostream>
#include<fstream>
using namespace std;

int main() {
    fstream file;
    file.open("file.txt");
    string word;

    while(file >> word) {
        cout << word << endl;
    }
    return 0;

    file.close();
}