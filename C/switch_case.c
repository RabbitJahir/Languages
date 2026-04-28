#include <stdio.h>
int main(){

char days;
printf("Select:\n1 for Sunday\n2 for Monday\n3 for Tuesday\n4 for Wednesday\n5 for Thursday\n6 for Friday\n7 for Saturday\n:  ");
scanf("%c", &days);

switch(days){
   case '1':
    printf("\nChose Sunday\n");
    printf("10:00-11:00 | CHEM0531175 | ITSH | 1A-510\n");
    printf("12:00-1:00  | MATH0541111 | TTC  | 1A-413\n");
    break;
   case '2':
    printf("\nChose Monday\n");
    printf("9:00-10:00 | CSE0613111 | SRN | 1A-512\n");
    printf("10:00-11:00| CSE0613112 | SRN | 1A-PS212\n");
    printf("12:00-1:00 | GED0232112 | AHE | 1A1-510\n");
    printf("1:00-2:00  | GED0232112 | IA  | 1A2-603\n");
    break;
   case '3':
    printf("\nChose Tuesday\n");
    printf("8:00-9:00  | GED0232111   | AHE  | 1A-602\n");
    printf("9:00-10:00 | PHY0533112   | MMJ  | 1A1-102\n");
    printf("10:00-11:00| PHY0533111   | MMJ  | 1A-603\n");
    printf("12:00-1:00 | CHEM051175   | ITSH | 1A-202\n");
    break;
   case '4':
     printf("\nChose Wednesday");
     printf("Chuti bro.");
    break;
   case '5':
     printf("\nChose Thursday\n");
     printf("9:00-10:00 | MATH0541111 | TTC  | 1A-603\n");
     printf("10:00-11:00| PHY0533112  | MMJ  | 1A2-102\n");
     printf("11:00-12:00| GED0232111  | AHE  | 1A-509\n");
     printf("12:00-1:00 | CSE0613111  | SRN  | 1A-204\n");
     printf("1:00-2:00  | PHY0533112  | MMJ  | 1A-509\n");
    break;
   case '6':
     printf("\nChose Friday");
    break;
   case '7':
     printf("\nChose Saturday");
    break;



}


return 0;

}
