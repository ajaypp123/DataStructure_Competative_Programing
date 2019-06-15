#include<iostream>
#include<fstream>
using namespace std;

int main() {
    fstream file;
    file.open("file.txt");
    string word;

    while(word != "end") {
        cin >> word;
        file << word << endl;
    }
    file.close();
    return 0;
}