
#include <iostream>
using namespace std;

int main() {

    int arr[] = {4, 5, 6, 7, 0, 1, 2};

    // Calculate the number of elements
    int size = sizeof(arr) / sizeof(arr[0]);

    // Set the starting and ending positions
    int left = 0;
    int right = size - 1;

    // Keep searching while the search range is valid
    while (left < right) {

        // Find the middle index
        int mid = left + (right - left) / 2;

        // If the middle element is greater than
        // the last element, the minimum is on the right
        if (arr[mid] > arr[right]) {
            left = mid + 1;
        }

        // Otherwise, the minimum is at mid or on the left
        else {
            right = mid;
        }
    }

    // left and right now point to the minimum element
    cout << "Minimum element: " << arr[left] << endl;

    return 0;
}
