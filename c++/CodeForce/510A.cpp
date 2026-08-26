#include <bits/stdc++.h>
using namespace std;

int main(){

    int h, w,dot=1;
    cin>>h>>w;

    for(int i=0;i<h;i++){
        if(i%2==0){
            for(int j=0;j<w;j++){
                cout<<"#";
            }
            cout<<endl;
        } else {
            if(dot){
                for(int j=0;j<w-1;j++){
                    cout<<".";
                }
                cout<<"#"<<endl;
                dot=0;
            } else {
                cout<<"#";
                for(int j=0;j<w-1;j++){
                cout<<".";
            }
            cout<<endl;
            dot=1;
            }
        }
    }
    return 0;
}