#include<iostream>
using namespace std;
int main(){
    int arr[] = {2,4,5,6};

    int find = 1;

    bool found = false;

    for(int i = 0; i<(sizeof(arr)/4); i++){
        int need = abs(find - arr[i]);
            for(int j = i+1; j<sizeof(arr)/4; j++){
                if(need == arr[j]){
                    cout<<arr[i]<<","<<arr[j]<<endl;
                    found=true;
                }
                
            }
            
    }
    if(found==false)
    cout<<"nope"<<endl;


}