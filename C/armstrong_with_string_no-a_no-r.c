#include <stdio.h>
#include <stdlib.h>

int armstrong_check();

int main()
{

    armstrong_check();

    return 0;
}

int armstrong_check()
{
    int i = 0, k = 0, j, sum = 0, count = 0, digit[100];
    char enter[100];

    printf("Enter a number: ");
    fgets(enter, sizeof(enter), stdin);

    while (enter[i] != '\0' && enter[i] != '\n')
    {
        digit[k++] = enter[i] - '0';
        count++;
        i++;
    }

    for (i = 0; i < count; i++)
    {
        int power = 1;
        for (j = 0; j < count; j++)
        {
            power *= digit[i];
        }
        sum += power;
    }

    int original = atoi(enter);

    if (sum == original)
        printf("%d is an Armstrong number.\n", original);
    else
        printf("%d is not an Armstrong number.\n", original);
}
