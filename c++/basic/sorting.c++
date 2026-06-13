#include <iostream>
using namespace std;
int main(){
    int number[] = {10,1,5,3,4};

    cout << sizeof(number)<<", size of gives value in 4 bytes"<<endl<<endl;

    for(int i=0;i<=(sizeof(number)/4)-1;i++){
        cout<<number[i]<<", ";
    }

    cout<<endl;
    cout<<endl;

    for (int i=0; i<=(sizeof(number)/4)-2; i++){
        for (int j =i+1; j<=(sizeof(number)/4)-1;j++){
            if (number[i] > number[j]){
                int temp = number[i];
                number[i] = number[j];
                number[j] = temp;
            };
        };
    };

    for(int i=0;i<=(sizeof(number)/4)-1;i++){
        cout<<number[i]<<", ";
    }

}