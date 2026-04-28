#include <stdio.h>
#include <unistd.h>

int main() {
    for (int i = 1; i <= 7; i++)
{
        for (int j = 1; j <= 7 - i; j++)
            printf(" ");
        for (int j = 1; j <= 2 * i - 1; j++) {
            printf("*");
            fflush(stdout);
            usleep(100000);
        }
        printf("\n");
}
    for (int i = 6; i >= 1; i--)
{
        for (int j = 1; j <= 7  - i; j++)
            printf(" ");
        for (int j = 1; j <= 2 * i - 1; j++) {
            printf("*");
            fflush(stdout);
            usleep(100000);
    }
        printf("\n");
}
    return 0;
}
