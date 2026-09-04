#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next;
};

int main(){

    Node* head = nullptr;
    Node* current = nullptr;

    // made line into string, so i can keep entering the numbers
    string line;

    // getline(), takes entire line, everything, along with spaces
    getline(cin, line);

    // stringstream(), separates inputs wih spaces, 11 12, becomes 11 and 12 different strings
    // apple spider, becomes apple and spider
    stringstream each_digit(line);

    int m;

    cout<<"Enter the numbers and press enter at last: ";

    // basically inputs, we take each_digit from streamstream(), and input them into int m, if its not an int, fail, while breaks;
    // as its inside while, each digit auto loops through all digits separated by spaces
    while(each_digit >> m){

        if(head == nullptr){

            head = new Node;

            head->data = m;
            head->next = nullptr;

            current = head;

        } else {

            Node* newNode = new Node;

            current->next = newNode;

            newNode->data = m;
            newNode->next = nullptr;

            current = newNode;
        }
    }

    // Print linked list
    current = head;

    while(current != nullptr){

        cout << current << " ] "
             << current->data
             << " [" << current->next << "]";

        current = current->next;

        if(current != nullptr)
            cout << " -> ";

        cout << endl;
    }

    return 0;
}