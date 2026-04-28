#include <stdio.h>
#include <string.h>

int main() {
    int c;
    char name[10], input[10];
    
    printf("Enter a line: ");
    while((c=getchar())!='\n' ){//getchar() just akta character ney, jekono kisu e character, jehetu loop e ase, so \n n howa porjonto sob nibe and put korbe.
        putchar(c);
    }
   printf("\n");

    fgets(name, sizeof(name), stdin); // fgets gets all the inputs, including the enter buttons newline character.
     name[strcspn(name, "\n")] = 0; // remove newline

   printf("\n");
    fgets(input, sizeof(input), stdin); // so the newline does not mess with the later functions. but only before not after.
     name[strcspn(name, "\n")] = 0; // remove newline
    fputs(name, stdout);
    fputs(input, stdout);
    return 0;
}
