#include <iostream>
#include <memory>
using namespace std;

//g++ -std=c++11 unique_ptr.cc; ./a.out

class Rectangle {
    int length;
    int breadth;

    public:
        Rectangle(int l, int b){
            length = l;
            breadth = b;
        }

        int area(){
            return length * breadth;
        }
};

int main(){

    unique_ptr<Rectangle> P1(new Rectangle(10, 5));
    cout << P1->area() << endl; // This'll print 50

    // unique_ptr<Rectangle> P2(P1);
    unique_ptr<Rectangle> P2;
    P2 = move(P1);

    // This'll print 50
    cout <<"P2" + P2->area() << endl;
    cout<<"P1" + P1->area()<<endl;   // Segmentation fault (core dumped)
    return 0;
}
