#include <bits/stdc++.h>
using namespace std;

const int SIZE = 5;

int front = -1;
int rear = -1;
int d[SIZE];

bool isfull() {
    return (front==0 && rear==SIZE-1);
}

bool isempty() {
    return front == -1;
}

void push(int input) {
    if (isfull()) {
        cout << "Queue is full. "<<input<<" can not be inserted."<<endl;
        return;
    }

    if (isempty()) {
        front = rear = 0;
    } else if(front==0 ){
        rear++;
    } else if(front!=0){
        front--;
        d[--front]=input;
        
        return;
    }

    d[rear] = input;
}

void pop() {
    if (isempty()) {
        cout << "Queue is empty"<<endl;
        return;
    }

    cout << "Removed: " << d[front] << '\n';

    if (front == rear) {
        front = rear = -1;
    } else {
        front++;
    }
}

void display() {
    cout<<endl;
    if (isempty()) {
        cout << "Queue is empty\n";
        return;
    }

    for(int i=front;i<=rear;i++){
        cout<<d[i]<<", ";
    }
    cout<<endl;
}

int main() {
    push(10);
    push(20);
    push(30);
    push(40);
    push(50);

    display();

    pop();
    pop();

    push(60);
    push(70);

    display();

    return 0;
}
