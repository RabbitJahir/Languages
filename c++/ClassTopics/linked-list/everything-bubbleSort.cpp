#include <bits/stdc++.h>
using namespace std;

struct Node{
    char data;
    Node* next;
};

int main(){

    string line;
    getline(cin, line);

    Node* head = nullptr;
    Node* current = nullptr;

    for(int i=0; i<line.length(); i++){
        if(head==NULL){
            head = new Node;
            head->data = line[i];
            head->next = nullptr;
            current = head;   
        } else {
            Node* newNode = new Node;
            current->next = newNode;

            newNode->data = line[i];
            newNode->next = NULL;

            current = newNode;
        }
    }

    
        int j=0,loop=0, inner=line.length();

    
    for( int i=0;i<line.length()-1;i++){
        current=head;
        while(current->next!=nullptr){

            if((int)current->data > (int)current->next->data){
                char temp = current->next->data;
                current->next->data = current->data;
                current->data = temp;
            }
        current = current->next;
            loop++;
            
        }
        j++;
    }
    cout<<j<<" "<<loop<<endl;
    
    current=head;
    while(current!=nullptr){
        cout<<current->data;
        if(current->next!=nullptr){
            cout<<"->";
        }
        current=current->next;
    }


    return 0;
}