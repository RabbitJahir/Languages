#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node *next;
};

Node* createNode(int val){
    Node *newNode = new Node();
    newNode->data = val;
    newNode->next = NULL;
    return newNode;
}

int main(){

    
    int n;
    cout<<"Enter n: ";
    cin>>n;

    int arr[n];
    cout<<"Enter arrays: ";

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    int value,indeX;
    cout<<"Enter index and value to add : ";
    cin>> indeX>> value;

    Node *head, *cur;
    head= NULL;

    for(int i=0;i<n;i++){
        Node *temp = createNode(arr[i]);
        if(head == NULL){
            head = temp;
            cur = temp;
        } else {
            cur->next=temp;
            cur = cur->next;
        }
    }
    cur=head;

    int i=0;
    while(cur!=NULL){
        if(i==indeX){
            cur->data=value;
        }
        cout<<cur->data;
        cur=cur->next;
        if(cur!= NULL){
            cout<<"->";
        } 
        i++;
    }

    return 0;
}