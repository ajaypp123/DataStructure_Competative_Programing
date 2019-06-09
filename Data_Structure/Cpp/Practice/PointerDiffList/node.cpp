#include "node.h"

Node::Node() {
    data = 0;
    ptrDiff = NULL;
}

Node::~Node() {
    data = 0;
    ptrDiff = NULL;
}

int Node::getData() {
    return this->data;
}

void Node::setData(int data) {
    this->data = data;
}

Node* Node::getPtrDiff() {
    return this->ptrDiff;
}

void Node::setPtrDiff(Node* temp) {
    this->ptrDiff = temp;
}