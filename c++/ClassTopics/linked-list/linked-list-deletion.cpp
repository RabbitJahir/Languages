#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next;
};

int main(){

    string line;
    int input;

    getline(cin, line);

    stringstream each(line);

Node* head = nullptr;
Node* current = nullptr;

while(each >> input){
    if(head==nullptr){
        head = new Node;

        head->data = input;
        head->next = nullptr;

        current = head;
    } else {
        Node* newNode = new Node;

        current->next = newNode;

        newNode->data = input;
        newNode->next = nullptr;

        current = newNode;
    }
}

current = head;
while(current!=nullptr){
    cout<<current<<" ] "<<current->data<<" ["<<current->next<<"]";
    current = current->next;
    if(current!=nullptr){
        cout<<"->";
    }
    cout<<endl;
}

cout<<endl;

int del;
cin>>del;

// how does deletion work
// support 3, 4, 5. We want to delete 4.
// currently, 3->next == 4 address, we will make 3->next be 5 address.
// for this we will keep the Node of the previous value of deletion value


// new pointer to store the current values
Node* skipster = nullptr;
current=head;
while(current!=nullptr){
    // current-> data finds the value to delete
    if(current->data == del){

        // saving the Node to be deleted in pointer toDelete
        Node* toDelete = current;

        // We change current to the value after the deletion value
        current = current->next;
        // we stored the before Node of deletion node, 
        // and we give the before node->next the address of the after deletion Node, 
        // thus the value that was to be deleted, lost itself from the link, but the actual Node is yet not deleted
        skipster->next = current;
        
        // this delete keyword, permanently deletes the Node, 
        delete toDelete;

        break;
    }
    // skipster has the current Node, but current changes to the next
    skipster = current;
    // current changes to next Node
    current = current->next;
}


current = head;
while(current!=nullptr){
    cout<<current->data;
    current = current->next;
    if(current!=nullptr){
        cout<<"->";
    }
}

    return 0;
}