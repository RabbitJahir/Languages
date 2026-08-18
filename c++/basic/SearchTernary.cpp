#include <bits/stdc++.h>
using namespace std;

int main(){

    int arr[10]= {1,2,3,4,5,6,7,8,9,10};

    int find = 4;

    int low=0;
    int high = 5-1;

    while(low<high){
        int mid1 = low + (high - low)/3;
        int mid2 = high - (high - low)/3;

        if(find<arr[mid1]){
            high=mid1-1;
        } else if (find>arr[mid2]){
            low = mid2+1;
        } else if(arr[mid1]== find){
            cout<<mid1;
            break;
        } else if(arr[mid2]== find){
            cout<<mid2;
            break;
        } else {
            low = mid1+1;
            high = mid2-1;
        }
    }

    return 0;
}