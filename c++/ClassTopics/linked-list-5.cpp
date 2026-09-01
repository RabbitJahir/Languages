#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next;
};

int main(){
int n,m;
cin>>n;
Node* head = nullptr;
Node* current = nullptr;

for(int i=0;i<n;i++){
    cin>>m;
    if(head==nullptr){
        head = new Node;

        head->data = m;
        head->next = nullptr;

        current = head;
    } else {
        Node* newNode = new Node;

        current->next = newNode;

        newNode->data = m;
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


current=head;
while(current!=nullptr){
    if(current->data == del){

        Node* temp = nullptr;
        temp = current->next-1;
        cout<<temp->data<<temp->next;
        
        break;
    }
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