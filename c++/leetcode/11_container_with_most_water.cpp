
#include <bits/stdc++.h>
using namespace std;

int main() {

    // The height of each vertical bar
    int arr[] = {1,8,6,2,5,4,8,3,7};

    // Total number of bars (columns)
    int col = sizeof(arr) / sizeof(arr[0]);

    // Find the tallest bar to determine the number of rows
    int row = arr[0];

    for (int i = 0; i < col; i++) {
        // If we find a taller bar, update the maximum height
        if (row < arr[i]) {
            row = arr[i];
        }
    }

    // Create a 2D map to represent all the bars
    // Each column represents one bar
    // Each row represents one unit of height
    int map[row][col];

    // Fill the 2D map with 1s and 0s
    for (int i = 0; i < col; i++) {

        for (int j = 0; j < row; j++) {

            // If the current row is below the bar's height,
            // mark this position as part of the bar
            if (j < arr[i]) {
                map[j][i] = 1;
            }

            // Otherwise, this position is empty space
            else {
                map[j][i] = 0;
            }

        }
    }

    // Print the map from top row to bottom row
    // This makes the bars look vertical when displayed
    for (int i = row - 1; i >= 0; i--) {

        for (int j = 0; j < col; j++) {
            cout << map[i][j] << " ";
        }

        cout << endl;
    }

    ////////////////////////////

    // Store the maximum container area found so far
    int biggest = 0;

    // Choose the first bar of the container
    for (int i = 0; i < col; i++) {

        // Choose the second bar
        // It must be to the right of the first bar
        for (int j = i + 1; j < col; j++) {

            // Water cannot be taller than the shorter bar
            int height = min(arr[i], arr[j]);

            // Distance between the two bars
            int width = j - i;

            // Calculate the water area between these two bars
            int area = height * width;

            // If this container holds more water than
            // our previous best, update the maximum
            if (area > biggest) {
                biggest = area;
            }

        }
    }

    // Print the largest container area
    cout << "\nMaximum water area: " << biggest;

    return 0;
}
