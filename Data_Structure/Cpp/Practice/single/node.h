#include<iostream>
using namespace std;

class Node {
    private:
        int data;
        Node* next;

    public:        
        Node();
        ~Node();
        int getData();
        void setData(int data);
        Node* getNext();
        void setNext(Node* temp);
};