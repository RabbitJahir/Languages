#include <bits/stdc++.h>
using namespace std;

const int SIZE = 5;

int front = -1;
int rear = -1;
int d[SIZE];

bool isfull() {
    return (rear + 1) % SIZE == front;
}

bool isempty() {
    return front == -1;
}

void push(int input) {
    if (isfull()) {
        cout << "Queue is full. " << input << " can not be inserted." << endl;
        return;
    }

    if (isempty()) {
        front = rear = 0;
    } else {
        rear = (rear + 1) % SIZE;
    }

    d[rear] = input;
}

void pop() {
    if (isempty()) {
        cout << "Queue is empty" << endl;
        return;
    }

    cout << "Removed: " << d[front] << '\n';
if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % SIZE;
    }
    
}

void display() {
    cout << endl;

    if (isempty()) {
        cout << "Queue is empty\n";
        return;
    }

    int i = front;

    while (true) {
        cout << d[i] << ", ";

        if (i == rear)
            break;

        i = (i + 1) % SIZE;
    }

    cout << endl;
}

int main() {
    push(10);
    push(20);
    push(30);

    display();

    pop();
    pop();

    push(60);
    push(70);

    display();

    return 0;
}