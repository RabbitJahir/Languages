#include <bits/stdc++.h>
using namespace std;


const int SIZE = 5;
int d[SIZE];

int pushfront = -1;
int pushrear = -1;


bool isfull() {
    return ( (pushfront==0 && pushrear==SIZE-1)  || (pushfront-pushrear == 1) );
}

bool isempty() {
    return pushfront == -1;
}

void pushtofront(int input) {
    if (isfull()) {
        cout << "stack is full\n";
        return;
    }

    if (isempty()) {
        pushfront = pushrear = 0;
    } else if (pushfront == 0) {
        pushfront = SIZE - 1;
    } else {
        pushfront--;
    }

    d[pushfront] = input;
}

void pushtorear(int input) {
    if (isfull()) {
        cout << "stack is full\n";
        return;
    }

    if (isempty()) {
        pushfront = pushrear = 0;
    } else if (pushrear == SIZE - 1) {
        pushrear = 0;
    } else {
        pushrear++;
    }

    d[pushrear] = input;
}



void popfront() {
    if (isempty()) {
        cout << "stack is empty\n";
        return;
    }

    if (pushfront == pushrear) {
        pushfront = pushrear = -1;
    } else if (pushfront == SIZE - 1) {
        pushfront = 0;
    } else {
        pushfront++;
    }
}

void poprear() {
    if (isempty()) {
        cout << "stack is empty\n";
        return;
    }

    if (pushfront == pushrear) {
        pushfront = pushrear = -1;
    } else if (pushrear == 0) {
        pushrear = SIZE - 1;
    } else {
        pushrear--;
    }
}

void display() {
    if (isempty()) {
        cout << "stack is empty\n";
    } else if (pushfront <= pushrear) {
        for (int i = pushfront; i <= pushrear; i++) {
            cout << d[i] << " ";
        }
    } else {
        for (int i = pushfront; i < SIZE; i++) {
            cout << d[i] << " ";
        }

        for (int i = 0; i <= pushrear; i++) {
            cout << d[i] << " ";
        }
    }

    cout << endl;
}


int main(){

   pushtofront(2);
   pushtorear(1);
   pushtorear(0);
   pushtofront(5);
   poprear();
   poprear();
   poprear();

    display();


    return 0;
}