#include<iostream>
using namespace std;
int main(){
    int nums[] = {2,7,3,11,1,5};

    for(int i=0; i<sizeof(nums)/4; i++){
        cout<<nums[i]<<",";
    }

    int count=0;
    int temp=0;

    cout<<endl;

    for(int i = 0; i<(sizeof(nums)/sizeof(nums[0]))-1 ;i++){
        for(int j =1; j<(sizeof(nums)/4)-i;j++){
            if(nums[i]>nums[i+j]){
                temp=nums[i];
                nums[i]=nums[j+i];
                nums[j+i]=temp;
            }
        }
        count++;
    }


    for(int i=0; i<sizeof(nums)/sizeof(nums[0]); i++){
        cout<<nums[i]<<",";
    }
    cout<<endl<<count;

}