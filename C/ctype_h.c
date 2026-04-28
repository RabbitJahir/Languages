#include <stdio.h>
#include <ctype.h>

int main() {
    char c[101];   // to store up to 100 characters
    int i = 0;
    char ch;

    printf("Enter a line (limit 100 symbols): ");

    // Read until newline or 100 chars
    while (i < 100 && (ch = getchar()) != '\n' && ch != EOF) {
        c[i] = ch;

        // Process character immediately
        if (isalpha(ch)) {
            printf("'%c' is a LETTER\n", ch);
        } else if (isdigit(ch)) {
            printf("'%c' is a DIGIT\n", ch);
        } else if (isspace(ch)) {
            printf("'%c' is a SPACE\n", ch);
        } else if (ispunct(ch)) {
            printf("'%c' is PUNCTUATION\n", ch);
        } else {
            printf("'%c' is OTHER\n", ch);
        }

        i++;
    }

    c[i] = '\0'; // Null-terminate string

    printf("\nFinal string: %s\n", c);

    return 0;
}
