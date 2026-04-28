#include <stdio.h>

typedef struct
{
    char name[20];
    int number;
    int acc_no;
    float balance;
} bank;

void acc_info(bank acc);

int main()
{

    int id;
    bank id1 = {"Alice", 101, 0001, 1500.50};
    bank id2 = {"Bob", 102, 0002, 2500.75};
    bank id3 = {"Charlie", 103, 0003, 3500.00};

    printf("Input your account number (0001 - 0003)\n: ");
    scanf("%d", &id);

    switch (id)
    {
    case 1:
        acc_info(id1);
        break;
    case 2:
        acc_info(id2);
        break;
    case 3:
        acc_info(id3);
        break;
    }

    return 0;
}

void acc_info(bank id)
{

    int input;
    float withdraw, deposit;
    printf("Account Holder: %s\n", id.name);
    printf("ID Number: %d\n", id.number);
    printf("Account Number: %d\n", id.acc_no);
    printf("Balance: %.2f\n\n", id.balance);

    printf("1 for withdraw\n2 for deposit\n : ");
    scanf("%d", &input);

    if (input == 1)
    {
        printf("How much do you want to withdraw: ");
        scanf("%f", &withdraw);
        id.balance = id.balance - withdraw;
        printf("New blance : %.2f", id.balance);
    }

    else
    {
        printf("How much do you want to deposit: ");
        scanf("%f", &deposit);
        id.balance = id.balance + deposit;
        printf("New blance : %.2f", id.balance);
    }
}