#include <bits/stdc++.h>
using namespace std;

int main(){

   string words[3][6] = {
    {"l", "o", "w"},
    {"l", "o", "w", "e", "r"},
    {"l", "o", "w", "e", "s", "t"}
   };

   int sizes[3]={3,5,6};

   string new_mat[5][2];
   int r=0,c=0;

   for(int i=0;i<3;i++){
        for(int j=0;j<sizes[i]-1;j++){
            cout<<words[i][j]<<words[i][j+1]<<" ";

        }
        cout<<endl;
   }

    return 0;
}