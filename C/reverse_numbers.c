#include<stdio.h>
int main()
{
    int size,i;
    scanf("%d",&size);

    int a[size];

    for(i=0;i<size;i++)
    {
        scanf("%d",&a[i]);
    }
    for(i=size-1;i>=0;i--)
    {
        printf("%d ",a[i]);
    }

    return 0;
}
