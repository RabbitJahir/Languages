#include <iostream>
using namespace std;
int main(){
    int inputs;
    cin>>inputs;

    int number[inputs];

    for(int i=0;i<inputs;i++){
        cin>>number[i];
    }

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

    int find;
    cout<<"find ? ";
    cin>>find;
    int low =0;
    int high = sizeof(number)/4-1;

    while(low<=high){
        int middle = low+ (high-low)/2;
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