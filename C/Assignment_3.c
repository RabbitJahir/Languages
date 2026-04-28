//04325205101006
//Kazi Rabit Jahir
//Sec 1A1
#include <stdio.h>
int main(){

int idays;
printf("Taking 1 year = 365 days, 1 month = 30 days.\nEnter days: ");
scanf("%d", &idays);

printf("%d years, %d month, %d days", idays/365, (idays%365)/30, (idays%365)%30);

return 0; }

