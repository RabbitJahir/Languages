#include <stdio.h>

typedef struct
{

    char name[100];
    // char account[100];
    // char id[100];

} acc;

int main()
{
    int i;

    acc n;
    for (i = 0; i < 5; i++)// 5 dile 3 ney, 3 dile 2 ney, 4 dile 2 ney
    {
        scanf("%c", &n.name[i]);
    }

    for (i = 0; i < 5; i++)
    {
        printf("%c", n.name[i]);
    }

    return 0;
}