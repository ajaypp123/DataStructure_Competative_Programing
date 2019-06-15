#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char *argv[])
{
  ifstream in("file.txt");
  char str[255];

  while(in) {
    in.getline(str, 255);  // delim defaults to '\n'
    if(in) cout << str << endl;
  }

  in.close();

  return 0;
}