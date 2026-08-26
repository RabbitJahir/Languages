#include <bits/stdc++.h>
using namespace std;

int main(){

    int n,sum=0;
    cin>>n;
string names="";
    for(int i=0;i<n;i++){
        cin>>names;
        if(names=="Tetrahedron"){
            sum+=4;
        } else if(names=="Cube"){
            sum+=6;
        } else if(names=="Octahedron"){
            sum+=8;
        } else if(names=="Dodecahedron"){
            sum+=12;
        } else {
            sum+=20;
        }
    }

    cout<<sum;
    return 0;
}