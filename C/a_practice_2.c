#include <stdio.h>
int main(){

int num, small=0, pos=0, temp=0;

scanf("%d", &num);

int enter[num];

for(int i=0;i<num;i++)
{
  scanf("%d", enter[i]);
  if(enter[i]< enter[i+1])
  {
      small = enter[i];
  pos = i;
  }
}

printf("Menor valor: %d\nPosicao: %d\n", small, pos);




return 0;
}
