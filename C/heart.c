#include<stdio.h>
int main(){
int i,j;

for(i=1;i<=4;i++)
{
    for(j=10;j>=3*i-1;j--)
        printf(" ");
    for(j=1;j<=3*i+1;j++)
        printf("*");
    for(j=1;j<=3*i+1;j++)
        printf("*");
    for(j=22;j>=6*i-1;j--)
        printf(" ");
    for(j=1;j<=3*i+1;j++)
        printf("*");
    for(j=1;j<=3*i+1;j++)
        printf("*");
    printf("\n");
}
for(i=1;i<=10;i++)
{
    for(j=1;j<=3*i-1;j++)
        printf(" ");
    for(j=25;j>=3*i-1;j--)
        printf("*");
    for(j=25;j>=3*i-1;j--)
        printf("*");

    printf("\n");
}

return 0;}
