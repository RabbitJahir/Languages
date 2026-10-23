#include <bits/stdc++.h>
using namespace std;

const int n = 10;
int arr[n];
int top = -1;

void push(int input){
    if (top == n - 1) {
        cout << "Stack Overflow!" << endl;
        return;
    }

    top++;
    arr[top] = input;
}

void pop(){
    if (top == -1) {
        cout << "Stack is empty!" << endl;
        return;
    }

    cout << "Popped: " << arr[top] << endl;
    top--;
}

void peek(){
    if (top == -1) {
        cout << "Stack is empty!" << endl;
        return;
    }

    cout << "peek: " << arr[top] << endl;
}

void display() {
    if (top==-1) {
        cout << "Stack is empty!" << endl;
        return;
    }

    for (int i = top; i >= 0; i--) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main(){

    // push, pop, peep, overflow, underflow, empty, stack[-1], isEmpty

    push(10);
    pop();

    display();

    return 0;
}
