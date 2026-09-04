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

    //head to start a link, current to continue the link
    
    // only pointers, no node yet
    Node* head = nullptr;
    Node* current = nullptr;

    for(int i=0;i<n;i++){
        int m;
        
        cin>>m;

        // starting with head to start a link
        // making the new node

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

    int quit=0;

    while(quit!=1){
        cout<<endl<<"Press "<<endl<<"1 to quit"<<endl<<"2 to edit linked list"<<endl<<"   : ";
        cin>>quit;
        if(quit==1){
            break;
        } else {

            int num, newNum;
            cout<<"Enter number and new_number to add after number: ";
            cin>>num>>newNum;

            // created a newNode, now newNode->data and newNode->next has random values
            Node* newNode = new Node;
            

            // getting the starter link
            current=head;
            while(current!=nullptr){
                // if the current->data matches the num then enter
                if(current->data == num){
                
                    // getting a temp Node*, to store the current->next
                    Node* temp = nullptr;

                    // current->next is now empty
                    temp = current->next;

                    // added newNode->data
                    newNode->data = newNum;

                    // current->next was empty, but in this line current->next got the address of newNode
                    current->next = newNode;

                    // newNode->next gets the address of temp, that was current->next, the next Node's address
                    newNode->next = temp;
                    cout<<newNode<<endl;
                    break;
                }
                current=current->next;
                }
                
                current=head;
                while(current!=nullptr){
                
                cout<<"["<<current<<"] "<<current->data<<" ["<<current->next<<"]";
                
                current=current->next;
                if(current!=nullptr){
                    cout<<"->";
                }
                cout<<endl;
                }

        }

    
    return 0;
}