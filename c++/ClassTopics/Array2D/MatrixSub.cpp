#include <bits/stdc++.h>
using namespace std;

int main() {
    int r1, c1;
    int r2, c2;

    cout << "Enter the number of rows and columns of first matrix: ";
    cin >> r1 >> c1;
    int mat1[r1][c1];

    cout << "Enter the number of rows and columns of second matrix: ";
    cin >> r2 >> c2;
    int mat2[r2][c2];

    if (r1 != r2 || c1 != c2) {
        cout << "Matrices cannot be added as they have different dimensions." << endl;
        return 0;
    }

    cout << "Enter the elements of the first matrix: ";
    for (int i = 0; i < r1; ++i) {
        for (int j = 0; j < c1; ++j) {
            cin >> mat1[i][j];
        }
    }

    cout << "Enter the elements of the second matrix: ";
    for (int i = 0; i < r2; ++i) {
        for (int j = 0; j < c2; ++j) {
            cin >> mat2[i][j];
        }
    }

    int sum[r1][c1];
    for (int i = 0; i < r1; ++i) {
        for (int j = 0; j < c1; ++j) {
            sum[i][j] = mat1[i][j] - mat2[i][j];
        }
    }

    cout << "The difference of the two matrices is: " << endl;
    for (int i = 0; i < r1; ++i) {
        for (int j = 0; j < c1; ++j) {
            cout << sum[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}