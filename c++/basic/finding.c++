#include <iostream>
using namespace std;
int main(){
    int number[] = {10,1,5,3,4,11};

    for (int i=0; i<(sizeof(number)/4)-1; i++){
        for (int j =i+1; j<=(sizeof(number)/4)-1;j++){
            if (number[i] > number[j]){
                int temp = number[i];
                number[i] = number[j];
                number[j] = temp;
            };
        };
    };

    for(int i = 0; i<(sizeof(number)/4); i++){
        cout << number[i] <<",";
    }

    cout<<endl;

    int find = 11;
    int low =0;
    int high = sizeof(number)/4;

    while(low<high){
        int middle = (low+high)/2;
        if(number[middle]<find){
            low = middle +1;
        }
        else if (number[middle] >find){
            high = middle -1;
        }
        else{
            cout<< middle +1 <<endl;
            break;
        }
    }

    if(low>high){
        cout<<"not found"<<endl;
    }
}