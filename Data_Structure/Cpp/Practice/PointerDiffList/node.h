#include<iostream>
using namespace std;

class Node {
    private:
        int data;
        Node* ptrDiff;

    public:        
        Node();
        ~Node();
        int getData();
        void setData(int data);
        Node* getPtrDiff();
        void setPtrDiff(Node* temp);
};