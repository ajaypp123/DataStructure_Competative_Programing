#include<iostream>
#include<fstream.h>
using namespace std;

int main() {
       ifstream fin;
       char ch;
       fin.open("demo.txt");
       cout<<"\nData in file...";
       while(!fin.eof()) {
              fin.get(ch);
              cout<<ch;
       }
       fin.close();
       return 0;
}