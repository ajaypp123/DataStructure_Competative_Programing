#include<iostream>
#include<fstream.h>
using namespace std;

void main() {
    ofstream fout;
    char ch;

    fout.open("demo.txt");
    do {
        cin.get(ch);
        fout.put(ch);
    }while(ch!=EOF);

    fout.close();
    cout << "\nData written successfully...";
}