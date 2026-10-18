#include <bits/stdc++.h>
using namespace std;

int main(){

    int arr[] = {2,1,0};

    // jotogula digit, totogula column
    int col = sizeof(arr) / sizeof(arr[0]);

    // highest digit equal to row
    int row = arr[0];

    for(int i=0;i<col;i++){
        if(row<arr[i]){
            row = arr[i];
        }
    }


    // 2D banachi
    int map[row][col];
    int k=0;

    // sideways banachi, i with col, j with row
    // horizontal print korte cheyechilam, but accidentally vertical print kori and answer pai
    // blocked water start hoy 1 0 and end hoy 0 1, the solution
    for(int i=0;i<col;i++){
        for(int j=0;j<row;j++){
            
            // array te jei digit, totoguli 1 print hobe
            if(arr[k]!=0){
                if(j<arr[k]){
                    map[j][i]=1;
                } else {
                    map[j][i]=0;
                }
            } else {
                map[j][i]=0;
            }
            
        }
        k++;
    }

    // vertical print

    // for(int i=0;i<col;i++){
    //     for(int j=0;j<row;j++){
    //         cout<<map[j][i]<<" ";
    //     }
    //     cout<<endl;
    // }

    // horizontal print

    // for(int i=row-1; i>=0;i--){
    //     for(int j=col-1; j>=0; j--){
    //         cout<<map[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }

    for(int i=0; i<row;i++){
        for(int j=0; j<col; j++){
            cout<<map[i][j]<<" ";
        }
        cout<<endl;
    }

    ////////////////////////////

    int rain_water=0;
    

    for(int i=0; i<row;i++){
        bool temp = false;
        int temp_rain_water = 0;
        int current_row_water = 0;
        
        for(int j=0; j<col-1; j++){
            // starting of blocked water
            if(map[i][j]==1 && map[i][j+1]==0){
                temp_rain_water++;
                temp=true;
                // counting of blocked water
            }  else if(temp==true && map[i][j]==0 && map[i][j+1]==0){
                temp_rain_water++;
                // if blocked water started and if it also ended, then transfer the current amount to a new variable, only for each rows
            }  else if( temp==true && map[i][j]==0 && map[i][j+1]==1){
                current_row_water+=temp_rain_water ;
                temp_rain_water=0;
                temp=false;
        }
    }
    // add each rows blocked water
    rain_water += current_row_water;
}

    cout<<endl<<rain_water;



    return 0;
}