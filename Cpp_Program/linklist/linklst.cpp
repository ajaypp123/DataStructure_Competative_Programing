#include<iostream>
using namespace std;

class Node{
    private:
        int data;
        Node *next;
    public:
        Node(){
            this->data = 0;
            this->next = NULL;
        }

        void setData(int data) {
            this->data = data;
        }

        int getData() {
            return this->data;
        }

        void setNext(Node *temp) {
            this->next = temp;
        }

        Node* getNext() {
            return this->next;
        }
};

class List {
    private:
        Node* head;
        Node* tail;

    public:
        List(){
            this->head = NULL;
            this->tail = NULL;
        }

        Node* getHead() {
            return this->head;
        }

        Node* getTail() {
            return this->tail;
        }

        void setHead(Node *temp) {
            this->head = temp;
        }

        void setTail(Node *temp) {
            this->tail = temp;
        }

        bool isEmpty() {
            return this->head == NULL && this->tail == NULL;
        }

        Node* newNode(int data) {
            Node* temp = new Node;
            temp->setData(data);
            temp->setNext(NULL);
            return temp;
        }
};

class SingleLinklist : public List {
    public:
        void addFirst(int data) {
            Node* temp = this->newNode(data);
            if(this->isEmpty()) {
                this->setHead(temp);
                this->setTail(temp);
            } else {
                temp->setNext(this->getHead());
                this->setHead(temp);
            }
        }

        void display() {
            Node* temp = this->getHead();
            while (temp != NULL) {
                cout << temp->getData() << endl;
                temp = temp->getNext();
            }

        }
};

int main() {
    SingleLinklist *list = new SingleLinklist();
    list->addFirst(10);
    list->addFirst(9);
    list->addFirst(8);
    list->addFirst(7);
    list->display();
    return 0;
}