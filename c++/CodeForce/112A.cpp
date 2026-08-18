#include <bits/stdc++.h>

using namespace std;

int main(){
string one, two;

cin>>one;
cin>>two;
int found=0;
for(int i=0;i<one.length();i++){
    char a = tolower(one[i]);
    char b = tolower(two[i]);

    if(a>b){
        found=1;
        break;
    } else if(a<b){
        found=2;
        break;
    }
}

if(found == 1){
    cout<<"1";
} else if(found == 2){
    cout<<"-1";
} else {
    cout<<"0";
}

    return 0;
}