// 1061

#include <stdio.h>
int main()
{

    int d1 = 0, d2, h1, h2, m1, m2, s1, s2;

    scanf("Dia %d", &d1);
    scanf("%d : %d : %d", &h1, &m1, &s1);
    scanf("Dia %d", &d2);
    scanf("%d : %d : %d", &h2, &m2, &s2);
    int total1 = s1 + m1 * 60 + h1 * 3600 + d1 * 86400;
    int total2 = s2 + m2 * 60 + h2 * 3600 + d2 * 86400;
    int diff = total2 - total1;

    printf("%d dia(s)\n%d hora(s)\n%d minuto(s)\n%d segundo(s)\n", diff / 86400, (diff % 86400) / 3600, ((diff % 86400) % 3600) / 60, ((diff % 86400) % 3600) % 60);

    return 0;
}