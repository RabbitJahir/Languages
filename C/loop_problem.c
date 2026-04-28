#include <stdio.h>
 
int main() {
 
   int N,sec,min,h;
   scanf("%d",&N);
   
   sec = N%60;
   h = N/3600;
   min = (N/60)%60;

   
   printf("%d:%d:%d\n", h, min,sec);
   
 
    return 0;
}