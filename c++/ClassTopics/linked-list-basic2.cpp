#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next; // this says to have space for another Node with next as variable name;
};

int main(){

    int n;
    cout<<"Enter initial amount of numbers : ";
    cin>>n;

    // making head node to start the link
    // giving head data a value to start the loop

    Node* head = new Node;
    head->data = 0;

    // a pointer that exists related to Node struct
    Node* now = nullptr;

    for(int i=0;i<n;i++){
        int m;
        
        cin>>m;

        // starting with head to start a link
        // making the new node

        if(head->data==0){
            
            // head->data is the input value, head->next is empty, as there is yet no next value
            head->data = m;
            head->next=nullptr;

            // current pointer has head Node's address
            now = head;
        } else {
            // making new Node for new inputs
            Node* newNode = new Node;

            
            // 1st iteration: current->next, current is still head, head->next is the newNode's address
            // all other iteration: current still has address of previous iterrations newNode so current->next means, the previous newNode->next, thus forming a chain
            now->next = newNode;

            // newNode->data, newNode->next is empty, for the same reason head was null, no next values/address yet
            newNode->data = m;
            newNode->next = nullptr;

            //current took the address of newNode
            now = newNode;
        }
    }


    Node* current = nullptr;
    current=head;
    while(current!=nullptr){
        // current prints the current values address
        cout<<current<<" ] "<<current->data<<" ["<<current->next<<"]";
        
        current=current->next;
        if(current!=nullptr){
            cout<<"->";
        }
        cout<<endl;
    }
            
    return 0;
}