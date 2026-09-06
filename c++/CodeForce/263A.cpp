#include <bits/stdc++.h>
using namespace std;

int main() {
    int matrix[5][5], count = 0;

    for (int r = 0; r < 5; r++) {
        for (int c = 0; c < 5; c++) {
            cin >> matrix[r][c];
        }
    }

    while (matrix[2][2] != 1) {

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {

                if (matrix[r][c] == 1) {

                    if (r > 2) {
                        swap(matrix[r][c], matrix[r-1][c]);
                        count++;
                    }
                    else if (r < 2) {
                        swap(matrix[r][c], matrix[r+1][c]);
                        count++;
                    }
                    else if (c > 2) {
                        swap(matrix[r][c], matrix[r][c-1]);
                        count++;
                    }
                    else if (c < 2) {
                        swap(matrix[r][c], matrix[r][c+1]);
                        count++;
                    }

                    break;
                }
            }

            if (matrix[2][2] == 1)
                break;
        }
    }

    cout << count;

    return 0;
}