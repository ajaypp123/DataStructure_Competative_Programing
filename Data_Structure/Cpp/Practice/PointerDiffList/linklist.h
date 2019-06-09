#include "node.h"

class Linklist {
    private:
        int count;
        Node* head;
        Node* tail;

    public:
        Linklist();
        ~Linklist();
        void inCount();
        void deCount();
        int getCount();
        Node* getHead();
        void setHead(Node* temp);
        Node* getTail();
        void setTail(Node* temp);
};