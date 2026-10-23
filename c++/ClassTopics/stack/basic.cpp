#include <bits/stdc++.h>
using namespace std;

const int capacity = 5;
int* basket[capacity] = {NULL};

void push(int input) {
    for (int i = 0; i < capacity; i++) {
        if (basket[i] == NULL) {
            basket[i] = new int(input);
            return;
        }
    }

    cout << "Basket is full!\n";
}

void pop(){
    for(int i=capacity; i>=0; i--){
        if(basket[i]!=NULL){
            cout<<"deleting "<< *basket[i]<<endl;
            basket[i]=NULL;
            return;
        } 
    }
    cout<<"basket is empty!";
}

void peek(){
    for(int i=capacity;i>=0;i--){
        if(basket[i]!=NULL){
            cout<<*basket[i]<<endl;
            return;
        }
    }
    cout<<"Basket is empty!";
}

void display() {
    for (int i = capacity; i >= 0; i--) {
        if (basket[i] != NULL) {
            cout << *basket[i] << " ";
        }
    }
    cout <<endl;
}

int main() {
    push(10);
    push(20);
    push(45);
    display();
    pop();
    pop();
    peek();
    pop();
    peek();
    


    display();

    for(int i=0;i<capacity;i++){
        delete basket[i];
        basket[i]= NULL;
    }

    return 0;
}
