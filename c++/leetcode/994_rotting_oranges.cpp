
#include <iostream>
using namespace std;

int main() {

    // 0 = empty, 1 = fresh orange, 2 = rotten orange
    int arr[3][3] = {
        {2, 1, 1},
        {0, 1, 1},
        {1, 0, 1}
    };

    int row = 3;
    int col = 3;

    int fresh = 0;
    int minutes = 0;

    // Count all fresh oranges
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {

            if (arr[i][j] == 1) {
                fresh++;
            }

        }
    }

    // Continue while fresh oranges remain
    while (fresh > 0) {

        // Remember which fresh oranges will rot this minute
        int temp[3][3] = {};

        // Check every position in the grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                // Only rotten oranges can spread rot
                if (arr[i][j] == 2) {

                    // Check the cell above
                    if (i > 0 && arr[i - 1][j] == 1) {
                        temp[i - 1][j] = 1;
                    }

                    // Check the cell below
                    if (i < row - 1 && arr[i + 1][j] == 1) {
                        temp[i + 1][j] = 1;
                    }

                    // Check the cell on the left
                    if (j > 0 && arr[i][j - 1] == 1) {
                        temp[i][j - 1] = 1;
                    }

                    // Check the cell on the right
                    if (j < col - 1 && arr[i][j + 1] == 1) {
                        temp[i][j + 1] = 1;
                    }
                }
            }
        }

        // Count how many oranges actually rot this minute
        int rotten_now = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (temp[i][j] == 1) {

                    // Make the fresh orange rotten
                    arr[i][j] = 2;

                    fresh--;
                    rotten_now++;
                }
            }
        }

        // If nothing rotted, the remaining fresh oranges
        // can never become rotten
        if (rotten_now == 0) {
            cout << -1 << endl;
            return 0;
        }

        // One minute has passed
        minutes++;
    }

    cout << minutes << endl;

    return 0;
}
