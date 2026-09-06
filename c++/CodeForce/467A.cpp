#include <bits/stdc++.h>
using namespace std;

int main(){

    int rooms,people,max,can_stay=0;

    cin>>rooms;
    for(int i=0;i<rooms;i++){
        cin>>people>>max;
        if(people<max-1){
            can_stay++;
        }
    }

    cout<<can_stay;



    return 0;
}