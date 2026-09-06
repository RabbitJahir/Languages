#include <iostream>
#include<cstring>
using namespace std;

int main() {
    int n;
    cin>>n;
    string words[n];
    for(int i=0;i<n;i++){
        cin>>words[i];
    }
char first,last;
int middle_size;

for(int i=0;i< n;i++){

    string temp = words[i];

    if(temp.length()>10){
        first=temp[0];
        last = temp[temp.length()-1];
        middle_size=(temp.substr(1, temp.length()-2)).length();
        
        string full_word = string(1,first)+to_string(middle_size)+last;
        words[i]=full_word;
    }
}
    for (int i = 0; i < n; i++) {
        cout << words[i] << endl;
    }

    return 0;
}