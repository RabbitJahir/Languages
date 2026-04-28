#include <stdio.h>

int main()
{
    int length, i, k = 0, count = 0;
    char num[100];
    int digit[100];

    fgets(num, sizeof(num), stdin);

    for (i = 0; num[i] != '\0' && num[i] != '\n'; i++)
    {
        digit[k] = num[i] - '0'; // different array positions and converting characters to string
        count++;
        k++;
    }
    for (k = count - 1; k >= 0; k--)
    {
        printf("%d", digit[k]);
    }

    return 0;
}
