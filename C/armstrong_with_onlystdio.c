#include <stdio.h>

int main()
{
    int enter, original, temp, i, sum = 0, count = 0;

    printf("Enter a number: ");
    scanf("%d", &enter);

    original = enter;
    temp = enter;

    while (temp != 0)
    {
        count++;
        temp /= 10;
    }

    temp = enter;

    while (temp != 0)
    {
        int digit = temp % 10;
        int power = 1;

        for (i = 0; i < count; i++)
        {
            power *= digit;
        }

        sum += power;
        temp /= 10;
    }

    if (sum == original)
        printf("%d is an Armstrong number.\n", original);
    else
        printf("%d is not an Armstrong number.\n", original);

    return 0;
}
