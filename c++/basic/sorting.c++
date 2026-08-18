#include <iostream>
using namespace std;
int main(){
    int number[] = {10,5,3,4,19,7,29,9,1,2,6};
int count =0;
    cout << sizeof(number)<<", size of given array in 4 bytes"<<endl<<endl;

    for(int i=0;i<(sizeof(number)/4);i++){
        cout<<number[i]<<", ";
    }

    cout<<endl;
    cout<<endl;

    for (int i=0; i<(sizeof(number)/4)-1; i++){
        for (int j =i+1; j<(sizeof(number)/4);j++){
            if (number[i] > number[j]){
                int temp = number[i];
                number[i] = number[j];
                number[j] = temp;
            };
            
        };
         count++;
    };

    for(int i=0;i<(sizeof(number)/4);i++){
        cout<<number[i]<<", ";
    }
    cout<<count;

}