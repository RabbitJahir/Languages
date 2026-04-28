#include <stdio.h>
int main(){

int days;
printf("Select:\n1 for Sunday\n2 for Monday\n3 for Tuesday\n4 for Wednesday\n5 for Thursday\n0 to exit\n:  ");
do {
scanf("%d", &days);


switch(days){
   case 1:
    printf("\nChose Sunday\n");
    printf("10:00-12:00 | CHEM0531175 | ITSH | 1A-510\n");
    printf("12:00-02:00 | MATH0541111 | TTC  | 1A-413\n");
    break;
   case 2:
    printf("\nChose Monday\n");
    printf("08:00-10:00 | CSE0613111 | SRN | 1A-512\n");
    printf("10:00-01:00 | CSE0613112 | SRN | 1A-212\n");
    printf("01:00-03:00 | GED0232112 | AHE | 1A1-510\n");
    printf("01:00-03:00 | GED0232112 | IA  | 1A2-603\n");
    break;
   case 3:
    printf("\nChose Tuesday\n");
    printf("08:00-10:00 | GED0232111 | AHE  | 1A-602\n");
    printf("10:00-12:00 | PHY0533112 | MMJ  | 1A1-102\n");
    printf("12:00-01:00 | PHY0533111 | MMJ  | 1A-603\n");
    printf("01:00-02:00 | CHEM051175 | ITSH | 1A-202\n");
    break;
   case 4:
     printf("\nChose Wednesday");
     printf("Chuti bro.");
    break;
   case 5:
     printf("\nChose Thursday\n");
     printf("09:00-10:00 | MATH0541111 | TTC  | 1A-603\n");
     printf("10:00-12:00 | PHY0533111  | MMJ  | 1A-603\n");
     printf("12:00-01:00 | GED0232111  | AHE  | 1A-509\n");
     printf("01:00-02:00 | CSE0613111  | SRN  | 1A-204\n");
     printf("02:00-04:00 | PHY0533112  | MMJ  | 1A2-102\n");
    break;
   case 0:
    return 101;
   default:
    printf("middle_finger\n");
}
}
while (days!= 0);

return 0;

}
