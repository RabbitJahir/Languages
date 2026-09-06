#include <stdio.h>

int main() {

    int  num1, num2;

    again:

    scanf("%d %d", &num1, &num2);
    if(num1<=0 || num2<=0)
    goto end;
    else
    {   int sum=0;
        if(num1>num2)
            for(int i=num2;i<=num1;i++)
            {
                printf("%d ", i);
                sum+=i;
            }
             printf("Sum=%d\n", sum);
        if(num2>num1)
        {
            for(int j=num1;j<=num2;j++)
            {
                printf("%d ", j);
                sum+=j;
            }
            printf("Sum=%d\n", sum);
        }
        if(num1==num2)
        {
            printf("%d %d Sum=%d\n", num1, num2, (num1+num2));
        }
    }
    goto again;

    end:

    return 0;
}
