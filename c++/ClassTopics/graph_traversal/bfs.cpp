#include <bits/stdc++.h>
using namespace std;

const int SIZE = 3;

// matrix stores the matrix
// que stores the temporary que
// result stores the pop()
int matrix[SIZE][SIZE];
int que[SIZE];
int result[SIZE];

int front = -1;
int rear = -1;
int up = 0;

void push(int input) {
    if (front == -1) {
        front = rear = 0;
    } else {
        rear = (rear + 1) % SIZE;
    }

    que[rear] = input;
}

int pop() {

    result[up++] = que[front];

    if (front == rear) {
        front = rear = -1;
    } else {
        front = (front + 1) % SIZE;
    }

    return que[front];
}

int main() {


    cout << "Enter 0 and 1's" << endl;

    for(int i = 0; i < SIZE; i++) {
        for(int j = 0; j < SIZE; j++) {
            cin>>matrix[i][j];
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


    int starting_node;
    cout<<"Enter starting node: ";
    cin>>starting_node;

    //////////////////////////////////////////

    int visited[SIZE] = {0};

    push(starting_node);
    visited[starting_node] = 1;

    while(front != -1) {

        // call pop function and store the return int to current, the first number from the queue
        int current = pop();

        for(int j = 0; j < SIZE; j++) {

            // then start from that current, because thats how BFS works
            if(matrix[current][j] == 1 && visited[j] == 0) {
                push(j);
                visited[j] = 1;
            }
        }
    }

    cout<<endl<< "BFS Traversal: ";

    for(int i = 0; i < up; i++) {
        cout << result[i] << " ";
    }

    return 0;
}
