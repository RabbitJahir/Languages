#include <bits/stdc++.h>
using namespace std;

int main(){

    int r=2,c=2, sumOfAll = 0;
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
        for(int j=0; j<c; j++){
            sumOfAll+= mat[i][j];
        }
    }

    cout<<sumOfAll;

    return 0;
}