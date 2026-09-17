#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next;
};

int main(){

    int n;
    cout<<"Enter initial amount of numbers : ";
    cin>>n;

    //head pointer to start a link, current pointer to continue the link
    
    // only pointers, no node yet
    Node* head = nullptr;
    Node* current = nullptr;

    // head and current exists somewhere in the memory

    for(int i=0;i<n;i++){
        int m;
        
        cin>>m;

        // starting with head to start a link
        // making the new node
        
        // initialized that head is null
        if(head==NULL){
            head = new Node;
            
            // head->data is the input value, head->next is empty, as there is yet no next value
            head->data = m;
            head->next=nullptr;

            // current pointer has head Node's address
            current = head;
        } else {
            // making new Node for new inputs
            Node* newNode = new Node;

            
            // 1st iteration: current->next, current is still head, head->next is the newNode's address
            // all other iteration: current still has address of previous iterrations newNode so current->next means, the previous newNode->next, thus forming a chain
            current->next = newNode;

            // newNode->data, newNode->next is empty, for the same reason head was null, no next values/address yet
            newNode->data = m;
            newNode->next = nullptr;

            //current took the address of newNode
            current = newNode;
        }
    }


    Node* kala = nullptr;

    current=head;
    while(current!=nullptr){
        // current prints the current values address
        cout<<current<<" ] "<<current->data<<" ["<<current->next<<"]";
        
        current=current->next;
        if(current!=nullptr){
            cout<<"->";
        }
        // just for practice
        cout<<endl;
    }
            
    return 0;
}