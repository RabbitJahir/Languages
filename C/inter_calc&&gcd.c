// 1022
#include <stdio.h>

void plus(int n1, int d1, int n2, int d2);
void minus(int n1, int d1, int n2, int d2);
void into(int n1, int d1, int n2, int d2);
void divide(int n1, int d1, int n2, int d2);

int main()
{

    int total, n1, d1, n2, d2;
    char op;
    scanf("%d", &total);

    for (int i = 0; i < total; i++)
    {
        scanf("%d / %d %c %d / %d", &n1, &d1, &op, &n2, &d2);
        if (op == '+')
            plus(n1, d1, n2, d2);
        else if (op == '-')
            minus(n1, d1, n2, d2);
        else if (op == '*')
            into(n1, d1, n2, d2);
        else if (op == '/')
            divide(n1, d1, n2, d2);
    }

    return 0;
}
void plus(int n1, int d1, int n2, int d2)
{
    printf("%d/%d\n", (n1 * d2 + n2 * d1), (d1 * d2));

    int plusn = (n1 * d2 + n2 * d1);
    int plusd = (d1 * d2);

    int a = plusn;
    int b = plusd;

    while (b != 0)
    {
        int temp = b;
        b = a % b;
        a = temp;
    }
    printf("%d/%d", (n1 * d2 + n2 * d1) / a, (d1 * d2) / a);
}

void minus(int n1, int d1, int n2, int d2)
{
    printf("%d/%d\n", (n1 * d2 - n2 * d1), (d1 * d2));

    int minusn = (n1 * d2 - n2 * d1);
    int minusd = (d1 * d2);

    int a = minusn;
    int b = minusd;

    while (b != 0)
    {
        int temp = b;
        b = a % b;
        a = temp;
    }
    printf("%d/%d", (n1 * d2 - n2 * d1) / a, (d1 * d2) / a);
}

void into(int n1, int d1, int n2, int d2)
{

    int inton = n1 * n2;
    int intod = d1 * d2;

    printf("%d/%d=", inton, intod);

    int a = inton;
    int b = intod;

    while (b != 0)
    {
        int temp = b;
        b = a % b;
        a = temp;
    }
    printf("%d/%d", (n1 * n2) / a, (d1 * d2) / a);
}

void divide(int n1, int d1, int n2, int d2)
{
    int dividen = n1 * d2;
    int divided = d1 * n2;
    printf("%d/%d\n", dividen, divided);

    int a = dividen;
    int b = divided;

    while (b != 0)
    {
        int temp = b;
        b = a % b;
        a = temp;
    }
    printf("%d/%d", (n1 * d2) / a, (d1 * n2) / a);
}