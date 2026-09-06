#include <bits/stdc++.h>
using namespace std;

int main(){
int n,m;
cin>>n;
for(int i=0;i<n;i++){
    cin>>m;
    if(m<=2){
        cout<<0;
    } else {
        cout<<(m-1)/2;
    }
    cout<<endl;
}
    return 0;
}