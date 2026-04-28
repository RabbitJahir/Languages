//04325205101006
//Kazi Rabit Jahir
//1A1
#include <stdio.h>
#include <math.h>

int main() {
    double a, b, c, D, root1, root2, real_part, imag_part;

    printf("ax^2 + bx + c, enter the values of a, b and c: ");
    scanf("%lf %lf %lf", &a, &b, &c);

    D = b * b - 4 * a * c;

    if (D > 0) {
        root1 = (-b + sqrt(D)) / (2 * a);
        root2 = (-b - sqrt(D)) / (2 * a);
        printf("Two real roots: %.2lf and %.2lf\n", root1, root2);
    } else if (D == 0) {
        root1 = -b / (2 * a);
        printf("One real root: %.2lf\n", root1);
    } else {
        real_part = -b / (2 * a);
        imag_part = sqrt(-D) / (2 * a);
        printf("Two complex roots: %.2lf + %.2lfi and %.2lf - %.2lfi\n",
               real_part, imag_part, real_part, imag_part);
    }

    return 0;
}

