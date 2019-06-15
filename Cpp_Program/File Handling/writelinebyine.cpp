#include<iostream>
#include<fstream>
using namespace std;

int main() {
    fstream file;
    file.open("file.txt");
    string line;

    while(line != "end") {
        getline(cin, line);
        file << line << endl;
    }
    file.close();
    return 0;
}