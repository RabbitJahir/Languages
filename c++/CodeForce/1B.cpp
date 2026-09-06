#include <bits/stdc++.h>
using namespace std;

int main(){

    string input;
    cin>>input;

    if(input[0]=='R'){
        size_t cPos = input.find('C');

        int R = stoi(input.substr(1, cPos-1));
        int C = stoi(input.substr(cPos+1));

        if(C<=26){
            cout<<(char)(C+64)<<endl;
        } else {
            char first_letter = (char)( (C/26)+64 );
            char second_letter = (char)( (C%26)+64 );     
            cout<<first_letter<<second_letter<<R<<endl;
        }

    } else {
        int i = 0;
        while (i < input.length() && isalpha(input[i])) {
            i++;
        }

        string letters = input.substr(0, i);
        int number = stoi(input.substr(i));

        int coor = ((int)letters[0]%64)*( 13*2+((int)letters[1]%64) )  ;        
        cout<<coor;

    }

    // hoy nai



    return 0;
}