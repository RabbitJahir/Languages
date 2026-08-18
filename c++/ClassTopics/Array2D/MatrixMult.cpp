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

    if (c1 != r2) {
        cout << "Matrices cannot be multiplied as they have incompatible dimensions." << endl;
        return 1;
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

    int mult[r1][c2];

    for (int i = 0; i < r1; ++i) {
        for (int j = 0; j < c2; ++j) {
            mult[i][j] = 0;
            for (int k = 0; k < c1; ++k) {
                mult[i][j] += mat1[i][k] * mat2[k][j];
            }
        }
    }

    for (int i = 0; i < r1; ++i) {
        for (int j = 0; j < c2; ++j) {
            cout << mult[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}