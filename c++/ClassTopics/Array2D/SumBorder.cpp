#include <bits/stdc++.h>
using namespace std;

int main() {
    int r, c, BorderSum = 0;
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

    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            if (i == 0) {
                BorderSum += matrix[i][j];
            } else if (i != 0 && i != r - 1 && (j == 0 || j == c - 1)) {
                BorderSum += matrix[i][j];
            } else if (i == r - 1) {
                BorderSum += matrix[i][j];
            }
        }
    }

    cout << BorderSum << endl;
    return 0;
}