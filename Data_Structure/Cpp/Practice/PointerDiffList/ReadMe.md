# create linllist with following structure

### Doubly linklist with ptrdiff

1. It is memory efficient disk.

Node:
    Data
    *ptrdiff

Here *ptrdff is Exor of privious and next Node pointer

Ordinary Representation:
Node A:
prev = NULL, next = add(B) // previous is NULL and next is address of B

Node B:
prev = add(A), next = add(C) // previous is address of A and next is address of C



Node C:
prev = add(B), next = add(D) // previous is address of B and next is address of D

Node D:
prev = add(C), next = NULL // previous is address of C and next is NULL

XOR List Representation:
Let us call the address variable in XOR representation npx (XOR of next and previous)

Node A:
npx = 0 XOR add(B) // bitwise XOR of zero and address of B

Node B:
npx = add(A) XOR add(C) // bitwise XOR of address of A and address of C

Node C:
npx = add(B) XOR add(D) // bitwise XOR of address of B and address of D

Node D:
npx = add(C) XOR 0 // bitwise XOR of address of C and 0

exor result:
    1 ^ 0 : 1
    0 ^ 0 : 1
    1 ^ 1 : 0
    0 ^ 1 : 1

In term of address:
    suppose we hace following linklist.
        A -> B -> C -> D

    Exor:
        Suppose we are at position C. Which has ptrdiff -> (B ^ D).
        And we have next and prev pointer.
        
        1. If we want to move C to D.
            (B ^ D) ^ D  ==> B

        2. If we want to move C to B.
            (B ^ D) ^ B ==> B