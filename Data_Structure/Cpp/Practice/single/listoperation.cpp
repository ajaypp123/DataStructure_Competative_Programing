#include "listoperation.h"

ListOperation::~ListOperation() {
    deleteList();
}

Node* ListOperation::createNode(int val) {
    Node* temp = new Node;
    temp->setData(val);
    temp->setNext(NULL);
    return temp;
}

void ListOperation::addFirst(int val) {
    Node *temp = createNode(val);

    if(li.getHead() == NULL){
        li.setHead(temp);
        li.setTail(temp);
    } else {
        temp->setNext(li.getHead());
        li.setHead(temp);
    }

    li.inCount();
}

void ListOperation::addLast(int val) {
    Node *temp = createNode(val);

    if(li.getHead() == NULL){
        li.setHead(temp);
        li.setTail(temp);
    } else {
        li.getTail()->setNext(temp);
        li.setTail(temp);
    }

    li.inCount();
}

void ListOperation::delFirst() {
    Node *temp = li.getHead();

    if(li.getHead() == NULL){
        cout<<"List already Empty.";
    } else {
        li.setHead(temp->getNext());
        delete temp;
        li.deCount();
    }
}

void ListOperation::delLast() {
    Node *temp = li.getHead();
    
    if(li.getHead() == NULL){
        cout<<"List already Empty.";
    } else if(li.getCount() == 1) {
        delete li.getHead();
        li.setHead(NULL);
        li.setTail(NULL);
        li.deCount();
    } else {
        while (temp->getNext() != li.getTail()) {
            temp = temp->getNext();
        }
        delete temp->getNext();
        li.setTail(temp);
        li.getTail()->setNext(NULL);
        li.deCount();
    }
}

void ListOperation::addAtPos(int val, int pos) {
    int loc = 1;
    if(pos > li.getCount()+1) {
        cout<<"Position is grater than no. of element."<<endl;
    } else if(pos == 1) {
        addFirst(val);
    } else  if(pos == li.getCount()+1) {
        addLast(val);
    } else {
        Node *next = createNode(val);
        next->setNext(li.getHead());
        Node *prev = NULL;
        while (loc != pos-1) {
            next = next->getNext();
            loc++;
        }
        prev->setNext(next->getNext());
        next->setNext(prev->getNext());
        prev->setNext(next);
        li.inCount();
    }
}

void ListOperation::delAtPos(int pos) {
    Node *temp = li.getHead();
    int loc = 1;

    if(pos > li.getCount()) {
        cout<<"\nPosition is grater than length of list."<<endl;
    } else if(pos == 1) {
        delFirst();
    } else if(pos == li.getCount()) {
        delLast();
    } else {
        while (pos-1 != loc) {
            temp = temp->getNext();
            loc++;
        }
        li.deCount();    
    }
}

int ListOperation::getAtPos(int pos) {
    Node *temp = li.getHead();
    int loc = 1;

    if(pos > li.getCount()) {
        cout<<"\nPosition is grater than length of list."<<endl;
        return -1;
    } else {
        while (pos != loc) {
            temp = temp->getNext();
            loc++;
        }
        return temp->getData();
    }
}

void ListOperation::Display() {
    Node *temp = li.getHead();

    cout<<"Display List:"<<endl;
    while(temp != NULL) {
        cout<<"\t"<<temp->getData();
        temp = temp->getNext();
    }
    cout<<"\nCount Node: "<<li.getCount()<<endl;
}

void ListOperation::deleteList() {
    while(li.getHead() != NULL) {
        Node *temp = li.getHead();
        li.setHead(li.getHead()->getNext());
        delete temp;
    }
}

void ListOperation::replaceAtPos(int val, int pos) {
    Node *temp = li.getHead();
    int loc = 1;

    if(pos > li.getCount()) {
        cout<<"\nPosition is grater than length of list."<<endl;
    } else {
        while (pos != loc) {
            temp = temp->getNext();
            loc++;
        }
        temp->setData(val);
    }
}

void ListOperation::reverseList() {
    int loc = 1;
    int temp;
    Node* next = li.getHead();
    Node* prev = NULL;
    while(loc <= li.getCount()/2) {
        temp = getAtPos(loc);
        replaceAtPos(getAtPos(li.getCount()-loc+1), loc);
        replaceAtPos(temp, li.getCount()-loc+1);
        loc ++;
    }
}