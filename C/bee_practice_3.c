//1146
#include <stdio.h>
int main(){

int x,n;

    scanf("%d", x);
int m=x;
     for(int i=1; i<x; i++)
     {
        n=x-i;
        m*=n;

     }
       
    printf("%d\n", m);


return 0;}
