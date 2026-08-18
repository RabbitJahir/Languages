#include <iostream>
using namespace std;

int main(){
  
    int capacity;

    cout << "Enter maximum array capacity: ";
    cin >> capacity;

    int arr[capacity];  

    cout << "Enter the elements:\n";
    for (int i = 0; i < capacity; i++) {
        cin >> arr[i];
    }

    int position;

    cout << "Enter position to delete: ";
    cin >> position;

    for (int i = position-1; i < capacity - 1; i++) {
        arr[i] = arr[i + 1];
    }
    for(int i=0; i < capacity - 1; i++) {
        cout << arr[i] << " ";
    }
 
    
    return 0;

}