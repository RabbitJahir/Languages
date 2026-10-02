#include <bits/stdc++.h>
using namespace std;

struct Node{
    Node* Head;
    char Data;
    Node* Tail;
};

int main(){

    string line;

    getline(cin, line);
    stringstream each(line);

    char m;
    Node* head = nullptr;
    Node* current = nullptr;
    Node* tail = nullptr;

    while(each>>m){

        if(head == NULL){
            head = new Node;
            head->Data = m;
            head->Head = head;
            head->Tail = nullptr;
            current=head;
        } else {
            Node* newNode = new Node;

            current->Tail = newNode;
            newNode->Data = m;
            newNode->Head = current->Tail;
            newNode->Tail = nullptr;

            current = newNode;
        }
    }

    current = head;
    while(current!=NULL){
        cout<<current->Head<<" -> "<<current->Data<<" -> "<<current->Tail;
        if(current->Tail!=nullptr){
            cout<<"\n";
        }
        current = current->Tail;
    }

    return 0;
}