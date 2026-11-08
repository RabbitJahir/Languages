#include <bits/stdc++.h>
using namespace std;

const int SIZE = 5;

int matrix[SIZE][SIZE];
int stackk[SIZE];
int result[SIZE];

int top = -1;
int up = 0;

void push(int input) {
    stackk[++top] = input;
}

int pop() {
    int temp = stackk[top--];
    result[up++] = temp;
    return temp;
}

int main() {

    cout << "Enter 0 and 1's" << endl;

    for(int i = 0; i < SIZE; i++) {
        for(int j = 0; j < SIZE; j++) {
            cin >> matrix[i][j];
        }
    }

    cout<<endl<<"##############################"<<endl;
    cout<<"      ";
    for(int i=0;i<SIZE; i++){
        cout<<i<<" ";
    }
    cout<<endl<<"   ____________"<<endl;
    for(int i = 0; i < SIZE; i++) {
        cout<<i<<"  |  ";
        for(int j = 0; j < SIZE; j++) {
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<"##############################"<<endl;

    //////////////////////////////////////////////////

    int visited[SIZE] = {0};

    push(0);
    visited[0] = 1;

    while(top != -1) {

        int current = pop();

        for(int j = 0; j < SIZE; j++) {

            // jeita last pop hoise, oi lane e search kore
            if(matrix[current][j] == 1 && visited[j] == 0) {
                push(j);
                visited[j] = 1;
            }
        }
    }

    cout <<endl<< "DFS Traversal: ";

    for(int i = 0; i < up; i++) {
        cout << result[i] << " ";
    }

    return 0;
}

// first push e 0 jache,
// then loop er bhitore top e 0 ache oita result e jache,
// 0 er lane e dhorlam 1 and 4 ache, push hoilo
// akhon int current = pop(), ai function top e 4 ke return korbe so result = 0,4 
// basically stack, LIFO