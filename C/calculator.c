//1022
#include <stdio.h>
#include <math.h>

void add() {
    float num1, num2, result;
    printf("\nEnter two numbers (separated by space): ");
    scanf("%f %f", &num1, &num2);
    result = num1 + num2;
    printf("Result: %f\n\n", result);
}

void sub() {
    float num1, num2, result;
    printf("\nEnter two numbers (separated by space): ");
    scanf("%f %f", &num1, &num2);
    result = num1 - num2;
    printf("Result: %f\n\n", result);
}

void mult() {
    float num1, num2, result;
    printf("\nEnter two numbers (separated by space): ");
    scanf("%f %f", &num1, &num2);
    result = num1 * num2;
    printf("Result: %f\n\n", result);
}

void divi() {
    float num1, num2, result;
    printf("\nEnter two numbers (numerator denominator): ");
    scanf("%f %f", &num1, &num2);
    if(num2 == 0) {
        printf("Error: Division by zero!\n\n");
        return;
    }
    result = num1 / num2;
    printf("Result: %f\n\n", result);
}

void square() {
    float num1, result;
    printf("\nEnter a number to square: ");
    scanf("%f", &num1);
    result = num1 * num1;
    printf("Result: %f\n\n", result);
}

void root() {
    float num1, result;
    printf("\nEnter a number to square root: ");
    scanf("%f", &num1);
    if(num1 < 0) {
        printf("Error: Cannot take square root of negative number!\n\n");
        return;
    }
    result = sqrt(num1);
    printf("Result: %f\n\n", result);
}

int main() {
    int op;

    printf("      SIMPLE CALCULATOR\n");

    do {
        printf("\nChoose an operation:\n");
        printf("1 - Addition\n2 - Subtraction\n3 - Multiplication\n4 - Division\n5 - Square\n6 - Square Root\n0 - Exit\n: ");
        scanf("%d", &op);

        switch(op) {
            case 1: add(); break;
            case 2: sub(); break;
            case 3: mult(); break;
            case 4: divi(); break;
            case 5: square(); break;
            case 6: root(); break;
            case 0: printf("Exiting...\n"); break;
            default: printf("Invalid choice! Please try again.\n");
        }

    } while(op != 0);

    return 0;
}
