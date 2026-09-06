#include <bits/stdc++.h>
using namespace std;

int main() {
    int r, c, DiagonalSum = 0;
    cin >> r >> c;
    int matrix[r][c];

    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            cin >> matrix[i][j];
        }
    }

    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }

    // middle diagonal er sum
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            if (i == j) {
                DiagonalSum += matrix[i][j];
                break;
            }
        }
    }

    // nicher diagonal er sum
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            if (i == j+1) {
                DiagonalSum += matrix[i][j];
                break;
            }
        }
    }

    // uporer diagonal er sum
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            if (i == j) {
                DiagonalSum += matrix[i][j];
                break;
            }
        }
    }
    
    cout << "Diagonal Sum : " << DiagonalSum << endl;
    return 0;
}