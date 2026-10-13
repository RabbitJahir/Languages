#include <bits/stdc++.h>
using namespace std;

int main(){

    string line;
    getline(cin, line);

    
    bool yes = true;
    if(line.length()>4){
        bool yes = false;
    } else {
        for(int i=0;i<line.length(); i++){
            if(line[i] !='G' && line[i]!='R'){
                bool yes = false;
                break;
            }
        }
    }

    if(yes==true && line[0]=='G'){
        cout<<"Green";
    } else if (line[0]=='R'){
        cout<<"Red";
    } else {
        cout<<"nah";
    }
    

    return 0;
}