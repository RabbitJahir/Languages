// Kazi_Rabit_Jahir
// 04325205101006
// Section_1A1
// Problem_1 
#include<stdio.h>
int main()
{
    int n,i=2,x=0;
    printf("Enter any number to get sum of all odd numbers from 1 upto that number: ");
    scanf("%d", &n);
    while(i<=n) {
        if(i%2==1){
          x+=i;
        printf("%d ", i);
        }
        i++;
    }
    printf(" = %d", x);
return 0;
}