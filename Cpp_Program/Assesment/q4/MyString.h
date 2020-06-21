#ifndef MYSTRING_H
#define MYSTRING_H

class MyString{
	
    private:
          char *name;
          int size;
    public:
           MyString();
           MyString(int);         
           MyString(MyString&);
           ~MyString();
	   void Accept();
           void Display();     
};   

#endif 
