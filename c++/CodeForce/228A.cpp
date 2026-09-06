#include <bits/stdc++.h>
using namespace std;

int main(){

    int colors[4],sum=0;

    for(int i=0;i<4;i++){
        cin>>colors[i];
    }

    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            if(colors[i]>colors[j]){
            swap(colors[i],colors[j]);
        }
        }
    }


    for(int i=0;i<3;i++){
        if(colors[i]==colors[i+1]){
            sum++;
        }
    }

    cout<<sum;
    return 0;
}


// #include <bits/stdc++.h>
// using namespace std;

// int main() {
//     int a, b, c, d;
//     cin >> a >> b >> c >> d;

//     set<int> colors = {a, b, c, d};

//     cout << 4 - colors.size();

//     return 0;
// }