#include <bits/stdc++.h>
using namespace std;

int main(){
int n,m;
cin>>n;
    for(int i=0;i<n;i++){
        cin>>m;
        int modulus=1;
            while(modulus!=0){
                cout<<m-(m%10)<<endl;
                m=m%10;
                cout<<m<<endl;
                
                modulus=m-(m%10);
        }
    }
    return 0;
}