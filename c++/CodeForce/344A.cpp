#include <bits/stdc++.h>
using namespace std;

int main(){

    int n,count=1;
    cin>>n;
    int magnets[n];
    for(int i=0;i<n;i++){
        cin>>magnets[i];
    }
    int start = magnets[0];
    for(int i=0;i<n;i++){
        
        if(start!=magnets[i]){
            start = magnets[i];
            count++;
        }
    }

cout<<count;
    return 0;
}