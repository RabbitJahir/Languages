#include <bits/stdc++.h>
using namespace std;

int main(){

    int r,c,maxpos[2],minpos[2],found=0,foundpos[2];
    cin>>r>>c;
    int matrix[r][c];

    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cin>>matrix[i][j];
        }
    }

    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }

    // let position 0,0 be max and min
    int max=matrix[0][0],min=matrix[0][0];

    int key;
    cin>>key;

    
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            // finding maximum
            if(matrix[i][j]>max){
                max=matrix[i][j];
                maxpos[0]=i;
                maxpos[1]=j;
            }
            // finding minimum
            if(matrix[i][j]<min){
                min=matrix[i][j];
                minpos[0]=i;
                minpos[1]=j;
            }
            if(matrix[i][j]==key){
                found=1;
                foundpos[0]=i;
                foundpos[1]=j;
            }
        }
    }


    if(found){
        cout<<"key found in position: ("<<foundpos[0]+1<<","<<foundpos[1]+1<<")"<<endl;
    }

        cout<<"Max value is: "<<max<<". Position: ("<<maxpos[0]+1<<","<<maxpos[1]+1<<")"<<endl;
        cout<<"Min value is: "<<min<<". Position: ("<<minpos[0]+1<<","<<minpos[1]+1<<")"<<endl;
    
    
        return 0;
}