#include "linklist.h"

class ListOperation {
    private:
        Linklist li;

    public:
        ~ListOperation();
        Node* XOR(Node*, Node*);
        Node* createNode(int);
        void addFirst(int);
        void addLast(int);
        void delFirst();
        void delLast();
        void Display();
        void addAtPos(int, int);
        void delAtPos(int);
        int getAtPos(int);
        void deleteList();
        void reverseList();
        void replaceAtPos(int val, int pos);
};