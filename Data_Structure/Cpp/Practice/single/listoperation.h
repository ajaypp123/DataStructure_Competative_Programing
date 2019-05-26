#include "linklist.h"

class ListOperation {
    private:
        Linklist li;

    public:
        ListOperation();
        ~ListOperation();
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
};