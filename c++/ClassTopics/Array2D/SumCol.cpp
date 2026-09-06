#include <bits/stdc++.h>
using namespace std;

int main(){

    int r=3,c=3, sumCol[c];
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
        sumCol[i]=0;
        for(int j=0; j<c; j++){
            sumCol[i]+=mat[j][i];
        }
    }

    for(int j=0; j<c; j++){
        cout<<"SUm of col "<<j<<" : "<<sumCol[j]<<endl;
    }


    return 0;
}