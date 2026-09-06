#include <bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cout<<"Enter total amount of numbers to be inputted: "; cin>>n;   

    int arr[n];

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int key;
    cout<<"enter key to find: "; cin>>key;

    for(int i=0;i<n;i++){
        if(arr[i]==key){
            cout<<"found key";
            break;
        } else if(i==n-1) {
            cout<<"key not found";
        }
    }

    return 0;
}