#include <stdio.h>

int main()
{
    int i, count = 0, k = 0;

    char input[100], rev[100];
    fgets(input, sizeof(input), stdin);

    for (i = 0; input[i] != '\0'; i++)
    {
        count++;
    }

    A:
    printf("true");
    for (i = count - 1; i >= 0; i--)
    {
       if( input[i] != input[count] )
       {
        break;
         goto A;
       }
      
    }

  
    return 0;
}
