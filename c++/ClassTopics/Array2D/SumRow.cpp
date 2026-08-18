#include <bits/stdc++.h>
using namespace std;

int main(){

    int r=3,c=3, sumRow[r];
    int mat[r][c];

    int k= 0;
    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            mat[i][j]=++k;
        }
    }

    for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
            cout<<mat[i][j]<<" ";
        }
        cout<<endl;
    }

    for(int i=0; i<r; i++){
        sumRow[i]=0;
        for(int j=0; j<c; j++){
            sumRow[i]+=mat[i][j];
        }
    }

    for(int i=0; i<r; i++){
        cout<<"SUm of row "<<i<<" : "<<sumRow[i]<<endl;
    }


    return 0;
}