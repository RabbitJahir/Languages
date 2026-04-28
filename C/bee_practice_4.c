//1022
#include <stdio.h>
#include <stdlib.h>

int main() {

    int n,N1, D1, N2, D2, num = 0, den = 0;
    char op;

    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        scanf("%d / %d %c %d / %d", &N1, &D1, &op, &N2, &D2);

        if (op == '+') {
            num = N1 * D2 + N2 * D1;
            den = D1 * D2;
        } else if (op == '-') {
            num = N1 * D2 - N2 * D1;
            den = D1 * D2;
        } else if (op == '*') {
            num = N1 * N2;
            den = D1 * D2;
        } else if (op == '/') {
            num = N1 * D2;
            den = N2 * D1;
        }

        printf("%d/%d\n", num, den);
    }

    return 0;
}
