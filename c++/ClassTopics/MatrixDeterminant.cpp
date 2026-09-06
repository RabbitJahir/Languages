#include <bits/stdc++.h>
using namespace std;

int main(){

    int r,c;
    cout<<"Enter the number of rows and columns of the matrix: ";
    cin>>r>>c;

    int mat[r][c];
    cout<<"Enter the elements of the matrix: ";
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cin>>mat[i][j];
        }
    }
    return 0;
}