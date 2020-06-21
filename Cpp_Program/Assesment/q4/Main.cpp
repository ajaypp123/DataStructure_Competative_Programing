#include"MyString.h"
#include<iostream>
#include<string>
using namespace std;

 int main()
 {
   int size;
   cout<<"Enter size : ";
   cin>>size;
   MyString m1(size);
   m1.Accept(); 
   MyString m2(m1);

   m1.Display();
   m2.Display();
   return 0;
 }
