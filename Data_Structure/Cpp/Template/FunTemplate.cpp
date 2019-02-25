#include<iostream>
using namespace std;
template<class T>

void mswap(T &r,T &v)
{
 T a;
 a=r;
 r=v;
 v=a; 
}

int main()
{
float a=10.10F,b=20.2F;
mswap(a,b);
cout<<a<<endl<<b<<endl;
 return 0;
}
