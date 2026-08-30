#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next;
};

int main(){

    int n;
    cin>>n;
    
    Node* head = nullptr;
    Node* current = nullptr;

    for(int i=0;i<n;i++){
        int m;
        cin>>m;

        if(head==NULL){
            head = new Node;
            
            head->data = m;
            head->next=nullptr;
            current= head;
        } else {
            Node* newNode = new Node;
            current->next = newNode;
            newNode->data = m;
            newNode->next = nullptr;
            current = newNode;
        }
    }

    return 0;
}