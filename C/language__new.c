//Print each word of the sentence in a new line.


#include<stdio.h>
int main(){
    char arr[1][100];
    int i;
    for( i=0;i<1;i++)
    fgets(arr[i], sizeof(arr[i]), stdin);
    for(i=0;i<10;i++)
    printf("%c",arr[i]);

    return 0;
        }
