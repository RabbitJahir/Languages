#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next;
};

int main(){

    int arr[] = {0,1,2,3,4,5};
    int k = 3;

    int n = sizeof(arr)/sizeof(arr[0]);

    Node* head = NULL;
    Node* current = NULL;

    // to find out how many times the reverse loop will run
    int loop = n/k;

    for(int i=0;i<n;i++){
        if(head==NULL){
            head = new Node;
            head->data = arr[i];
            head->next = NULL;
            current=head;
        } else {
            Node* newNode = new Node;
            newNode->data = arr[i];
            newNode->next=NULL;
            current->next = newNode;
            current= newNode;
        }
    }

    current=head;
    while(current!=NULL){
        cout<<current->data;
        current=current->next;
        if(current!=nullptr){
            cout<<"->";
        }
    }
    cout<<endl<<endl;
    
    /////////////////////////////////////////////////////////////////////


    
    

    current=head;
    Node* random = new Node();

    // assinging the address of head, to use later
    random->next = head;


    Node* groupPrev = random;

    for(int l=0; l<loop; l++){
        // grouphead is now the end of the first reverse
        // 0 1 2 3 4 5, k=6
        // head is 0, but we know head will be the at end in the upcoming loop, so we need to cuonnect the next value with the head
        Node* groupHead = current;
        Node* prev = NULL;

        for(int i=0; i<k; i++){
            // the normal reverse algo
            // first : 2 1 0
            // second: 5 4 3
            Node* next = current->next;
            current->next = prev;
            prev = current;
            current= next;
        }
        
        // groupPrev has the value of heads address, as it will come to the end, it will become zero after first loop
        // 
        groupPrev->next = prev;

        // connecting grouphead, that was head, now is the end value, connected head to the next value of the lineup, 2 1 0 3 4 5, that is 3
        groupHead->next = current;        
        
        // points to node 0, the first groupHead
        groupPrev = groupHead;

    }
    
    /////////////////////////////////////////////////////////////////////

    // only contains the address of the head, not the value, plus we never changed head's address
    head = random->next;

    current=head;
    while(current!=NULL){
        cout<<current->data;
        current=current->next;
        if(current!=nullptr){
            cout<<"->";
        }
    }

    return 0;
}