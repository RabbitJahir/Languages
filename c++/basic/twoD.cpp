#include <bits/stdc++.h>
using namespace std;

int main(){

    int rows, cols;

    cin >> rows >> cols;

    int arr[rows][cols];

    int count = 0;

    for(int a = 0; a < rows; a++){
        for(int b = 0; b < cols; b++){
            arr[a][b] = count++;
        }
    }

    // printing
    for(int a = 0; a < rows; a++){
        for(int b = 0; b < cols; b++){
            cout << arr[a][b] << " ";
        }
        cout << endl;
    }

    return 0;
}