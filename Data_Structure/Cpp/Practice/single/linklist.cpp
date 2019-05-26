#include "linklist.h"

Linklist::Linklist() {
    count = 0;
    head = NULL;
    tail = NULL;
}

Linklist::~Linklist() {
    count = 0;
    head = NULL;
    tail = NULL;
}

void Linklist::inCount() {
    count++;
}

void Linklist::deCount() {
    count--;
}

int Linklist::getCount() {
    return count;
}

Node* Linklist::getHead() {
    return this->head;
}

void Linklist::setHead(Node* temp) {
    this->head = temp;
}

Node* Linklist::getTail() {
    return this->tail;
}

void Linklist::setTail(Node* temp) {
    this->tail = temp;
}