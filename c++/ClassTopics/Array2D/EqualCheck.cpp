#include <bits/stdc++.h>
using namespace std;

int main(){
    int r1, c1;
    int r2, c2;

    cout << "Enter the number of rows and columns of first matrix: ";
    cin >> r1 >> c1;
    int mat1[r1][c1];

    cout << "Enter the number of rows and columns of second matrix: ";
    cin >> r2 >> c2;
    int mat2[r2][c2];

    if (c1 !=c2 || r1!=r2) {
        cout << "Matrix dimensions must be similar to be identical." << endl;
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

    int found=0;

    for(int i=0;i<r1;i++){
        for(int j=0;j<c1;j++){
            if(mat1[i][j]!=mat2[i][j]){
                found = 1;
                break;
            }
        }
    }

        if(found){
            cout<<"Matrices are identical";
        } else {
            cout<<"Matrices arent identical";
        }
        
    return 0;
}