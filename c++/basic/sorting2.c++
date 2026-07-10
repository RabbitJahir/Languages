#include<iostream>
using namespace std;
int main(){
    int nums[] = {2,7,3,11,1,5};
    int newnum[] = {};
    for(int i=0; i<sizeof(nums)/4; i++){
        cout<<nums[i]<<",";
    }

    for(int i = 0;i<sizeof(nums)/4;i++){
        for(int j =1; j<(sizeof(nums)/4)-1;j++){
            if(nums[i]>nums[j]){
                nums[i] = temp;
                nums[]
            }
        }
    }

}