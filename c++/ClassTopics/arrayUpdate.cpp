#include <iostream>
using namespace std;

int main() {
    int capacity;

    cout << "Enter maximum array capacity: ";
    cin >> capacity;

    int arr[capacity];  

    cout << "Enter the elements:\n";
    for (int i = 0; i < capacity; i++) {
        cin >> arr[i];
    }

    int position, element;

    cout << "Enter position: ";
    cin >> position;

    cout << "Enter new element: ";
    cin >> element;

    for (int i = capacity - 1; i >= position; i--) {
        arr[i + 1] = arr[i];
    }

    arr[position] = element;

    cout << "\nUpdated array:\n";
    for (int i = 0; i < capacity; i++) {
        cout << arr[i] << " ";
    }

    return 0;
}