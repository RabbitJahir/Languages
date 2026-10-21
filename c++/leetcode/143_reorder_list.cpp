
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* next;

    Node(int value) {
        data = value;
        next = nullptr;
    }
};

int main() {

    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);

    Node* head = nullptr;
    Node* tail = nullptr;

    // Insert array elements into the linked list
    for (int i = 0; i < size; i++) {

        Node* newNode = new Node(arr[i]);

        if (head == nullptr) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    // Print the original linked list
    cout << "Original: ";

    Node* temp = head;

    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }

    cout << endl;

    // Find the middle using slow and fast pointers
    Node* slow = head;
    Node* fast = head;

    while (fast->next != nullptr &&
           fast->next->next != nullptr) {

        slow = slow->next;
        fast = fast->next->next;
    }

    // Reverse the second half of the linked list
    Node* current = slow->next;
    Node* previous = nullptr;

    slow->next = nullptr;

    while (current != nullptr) {

        Node* nextNode = current->next;

        current->next = previous;

        previous = current;
        current = nextNode;
    }

    // Merge the two halves alternately
    Node* first = head;
    Node* second = previous;

    while (second != nullptr) {

        Node* nextFirst = first->next;
        Node* nextSecond = second->next;

        first->next = second;
        second->next = nextFirst;

        first = nextFirst;
        second = nextSecond;
    }

    // Print the reordered linked list
    cout << "Reordered: ";

    temp = head;

    while (temp != nullptr) {
        cout << temp->data << " ";
        temp = temp->next;
    }

    cout << endl;

    return 0;
}
