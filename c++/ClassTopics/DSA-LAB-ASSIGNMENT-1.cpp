#include <bits/stdc++.h>
using namespace std;

void bubbleSort(int inputs[], int numbers){
    for(int i=0; i<numbers-1; i++){
        for(int j=0; j<numbers-1-i; j++){
            if(inputs[j]>inputs[j+1]){
                int temp=0;
                temp=inputs[j];
                inputs[j]=inputs[j+1];
                inputs[j+1]=temp;            
            }
        }
    }
}

void honestyCheck(int inputs[], int old_inputs[], int numbers, int find){
    
    int sort_question_mark;
    
    cout<<endl;
    cout<<"Is your given array sorted?"<<endl<<"1: Yes"<<endl<<"2: No"<<endl<<"Enter 1 or 2: ";    cin>>sort_question_mark; cout<<endl;

    switch(sort_question_mark){
        case 1: 
            for(int i=0;i<numbers;i++){
                if(old_inputs[i]!=inputs[i]){
                    cout<<"Lying is moha pap!"<<endl; cout<<"Here is your sorted array:"<<endl; break;
                } else if(i==numbers-1) {
                    cout<<"Thank you for your honesty"<<endl; cout<<"Here is your given array:"<<endl;
                }
            }
            for(int i = 0; i < numbers; i++){
                cout<<inputs[i]<<", ";
            } 
            cout<<endl; cout<<"will search for : "<<find<<", on the upper array"<<endl<<endl;
            break;
        case 2:
            for(int i=0;i<numbers;i++){
                if(old_inputs[i]!=inputs[i]){
                    break;
                } else if( i==numbers-1) {
                    cout<<"Your given array is sorted!"<<endl;
                }
            }
            cout<<"Here is your sorted array:"<<endl;
            for(int i = 0; i < numbers; i++){
                cout<<inputs[i]<<", ";
            }
            cout<<endl;
            cout<<"will search for : "<<find<<", on the upper array"<<endl<<endl;
    }
}

int search(){
    int algo;

    cout<<"What algorithm would you like to use :"<<endl<<"1: Linear Search"<<endl<<"2: Binary Search"<<endl<<"3: Ternary Search"<<endl<<"Enter 1,2 or 3: "; cin>>algo;
    cout<<endl<<endl;
    return algo;
}

void linear(int inputs[], int numbers, int find){
    for(int i=0;i<numbers;i++){
        if(inputs[i]==find){
            cout<<"Found : "<<find<<", at index : "<<i;
            break;
        } else if(i==numbers-1) {
            cout<<"Number : "<<find<<" not found in array"<<endl;
            for(int i = 0; i < numbers; i++){
                cout<<inputs[i]<<", ";
            }
        }
    }
}

void binary(int inputs[], int numbers, int find){
    int left = 0;
    int right = numbers-1;
    while(left<=right){
        int middle = left + (right - left)/2;
        if(inputs[middle]<find){
            left = middle +1;
        }
        else if (inputs[middle] >find){
            right = middle -1;
        }
        else{
            cout<<"Found : "<<find<<", at index : "<<middle;
            break;
        }
    }

    if(left>right){
        cout<<"not found"<<endl;
    }
}

void ternary(int inputs[], int numbers, int find){
    int left=0;
    int right=numbers-1;
    
    while(left<=right){
        int mid1 = left+(right-left)/3;
        int mid2 = right-(right-left)/3;

        if(find<inputs[mid1]){
            right=mid1-1;
        } else if(find>inputs[mid2]){
            left=mid2+1;
        } else if(find==inputs[mid2]){
            cout<<"Found at index :"<<mid2;
            break;
        } else if(find==inputs[mid1]){
            cout<<"Found at index :"<<mid1;
            break;    
        } else {
            left=mid1+1;
            right=mid2-1;
        }
    }
    if(left>=right){
        cout<<find<<", not found.";
    }

}


int main(){

int numbers;
cout<<"How many numbers to input: "; cin>>numbers;

cout<<"Enter "<<numbers<<" numbers: "; int inputs[numbers];
for(int i = 0; i < numbers; i++){
    cin>>inputs[i];
}

int find; cout<<"What value would you like to search in here: "; cin>>find; cout<<endl;

int old_inputs[numbers];
for(int i = 0; i < numbers; i++){
    old_inputs[i]=inputs[i];
}

bubbleSort(inputs, numbers);
honestyCheck(inputs, old_inputs, numbers, find);

int search_alrogithm = search();

switch (search_alrogithm){
    case 1: 
        cout<<"Searching in Linear algorithm"<<endl;
        linear(inputs, numbers, find);
        break;
    case 2: 
        cout<<"Searching in Binary algorithm"<<endl;
        binary(inputs, numbers, find);
        break;
    case 3: 
        cout<<"Searching in Ternary algorithm"<<endl;
        ternary(inputs, numbers, find);
        break;
}
    return 0;
} 

