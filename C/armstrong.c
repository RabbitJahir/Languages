    #include <stdio.h>

int main() {
    int enter, sum = 0;

   scanf("%d", &enter);
   
    int original = enter;
   
    while (enter != 0) {
        int digit = enter % 10;
        sum += digit * digit * digit;
        enter /= 10;
    }

    if (sum == original) {
        printf("%d is an Armstrong number.\n", original);
    } else {
        printf("%d is not an Armstrong number.\n", original);
    }

    return 0;
}
