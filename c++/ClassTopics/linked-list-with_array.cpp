#include <bits/stdc++.h>
using namespace std;

// singly linked list, only knows where the next node is,
// making the next node
struct Node{
    int data;
    Node* next;
};
// int data, the actual data of int data type
// Node* next, the next node as next, and the actual address of the the next data, using pointer

int main(){

    int n;
    cout<<"Enter number of total elements:"; cin>>n;

    // double pointer (**), a pointer who points to another pointer
    // creating a memory gives it random data, creting Node* will give it random data and next, thus easier to appoint data,
    // nodes is now a pointer to Node*, so Node** has Node* has nodes

    // Node*[n] creates arrays of Node*, 4 means Node*[4], 0,1,2,3 Node*
    // if n is 4, we will have 4 Node* and the variables will be nodes[0], nodes[1], nodes[2], nodes[3]
    
    Node** nodes = new Node*[n];

    cout<<"Enter the elements: ";
    for(int i=0; i<n; i++){
        nodes[i] = new Node;
    }

    for(int i=0;i<n;i++){
        int m;
        cin>>m;
        nodes[i]->data = m;

        // if, for the last node,
        if(i==n-1){
            nodes[i]->next=nullptr;
        // else, because nodes already have values, we are just reassigning data, but the next already has values
        } else {
            nodes[i]->next = nodes[i+1];
        }
    }

    for(int i=0;i<n;i++){

        if(i==n-1){
            cout<<"["<<nodes[i]->next<<"] ";
        }else {
            cout<<"["<<nodes[i+1]->next<<"] ";
        }
        cout<<nodes[i]->data;
        cout<<" ["<<nodes[i]->next<<"]";
        if((nodes[i]->next)!=nullptr ){
            cout<<" -> ";
        }
        cout<<endl;
    }

   //HUGE LIMITATION

    return 0;
}


/*

nodes[0]->data = 1
nodes[0]->next = random2

nodes[1]->data = 2
nodes[1]->next = random3

nodes[2]->data = 3
nodes[2]->next = random4

nodes[3]->data = 4
nodes[3]->next = random5

nodes[4]->data = 5
nodes[4]->next = null

nodes[0]->

*/