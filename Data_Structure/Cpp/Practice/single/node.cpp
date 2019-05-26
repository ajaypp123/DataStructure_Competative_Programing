#include "node.h"

Node::Node() {
    data = 0;
    next = NULL;
}

Node::~Node() {
    data = 0;
    next = NULL;
}

int Node::getData() {
    return this->data;
}

void Node::setData(int data) {
    this->data = data;
}

Node* Node::getNext() {
    return this->next;
}

void Node::setNext(Node* temp) {
    this->next = temp;
}