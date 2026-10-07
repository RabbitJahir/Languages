#include <bits/stdc++.h>
using namespace std;

int main(){

    // int n;
    // cin>>n;
    // int a[n];
    // for(int i=0;i<n;i++){
    //     cin>>a[i];
    // }
    
    string write;
    getline(cin, write);

    stringstream each(write);
    int num;

    vector<int> a;

    while(each>>num){
        a.push_back(num);
    }

    cout<<endl;

    // for(int i=1;i<n;i++){
    //     int key = a[i];
    //     int j = i-1;
    //     while(j>=0 && a[j] > key){
    //         a[j+1] = a[j];
    //         j--;
    //     }
    //     a[j+1] = key;
    // }

    for(int i=1;i<a.size();i++){
        bool yes = true;
        while(i>0 && yes){
            if(a[i-1] > a[i]){
                swap(a[i] , a[i-1]);
                    // if(i==1)
                    //     continue;
                    // else
                        i-=1; 
            } else {
                yes = false;
            }
        }
    }

    for(int i=0;i<a.size();i++){
        cout<<a[i]<<" ";
    }

    return 0;
}