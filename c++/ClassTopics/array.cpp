# include<iostream>
using namespace std;

int main(){
int arr[1000];
int n;
cout<<"Enter the arry  size";
cin>>n;

for(int i=0;i<n;i++)
{
    cin>>arr[i];
}
cout<<"Element of the array:";
for(int i=0;i<n;i++){
     cout<<" "<<arr[i];
}
return 0;
}


// array operations - tranverse,, insert, delete, update 