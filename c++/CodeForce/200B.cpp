#include <bits/stdc++.h>
using namespace std;

int main(){

    int n,m;cin>>n;
    double sum=0;
    for(int i=0;i<n;i++){
        cin>>m;
        sum+=m;
    }
    cout<<fixed<<setprecision(12)<<(sum)/n;

    return 0;
}