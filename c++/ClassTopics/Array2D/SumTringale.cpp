#include <bits/stdc++.h>
using namespace std;

int main(){

    int r,c, upperTriangleSum=0, lowerTriangleSum=0;
    cin>>r>>c;
    int matrix[r][c];

    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cin>>matrix[i][j];
        }
    }

    for(int i=0;i<r;i++){
        for(int j=0+i;j<c;j++){
            upperTriangleSum+=matrix[i][j];
        }
    }

    for(int i=0;i<r;i++){
        for(int j=0;j<=i;j++){
            lowerTriangleSum+=matrix[i][j];
        }
    }

    cout<<upperTriangleSum<<endl;
    cout<<lowerTriangleSum<<endl;


    return 0;
}