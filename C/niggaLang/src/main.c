#include <stdio.h>
#include <string.h>

// gcc src/main.c -o nigga
// ./nigga hello.nigga
// ./nigga test.nigga

int main(int argc, char *argv[])
{
    if (argc != 2){
        printf("Usage: ./nigga <file.nigga>\n");
        return 1;
    }

    FILE *file;
    

    file = fopen(argv[1], "r");

    if (file == NULL)
    {
        printf("Could not open file.\n");
        return 1;
    }

    //---------------------------------------------------------------------
    //---------------------------------------------------------------------

    char line[256];

    while (fgets(line, sizeof(line), file))
    {
        if (strncmp(line, "say ", 4) == 0)
        {
            char *text = line + 4;

            /* Remove the newline */
            text[strcspn(text, "\n")] = '\0';

            /* Remove surrounding quotes */
            if (text[0] == '"' && text[strlen(text) - 1] == '"')
            {
                text[strlen(text) - 1] = '\0';
                text++;
            }

            printf("%s", text);
        } else if (strncmp(line, "sayl ", 5) == 0){
            char *text = line + 5;

            /* Remove the newline */
            text[strcspn(text, "\n")] = '\0';

            /* Remove surrounding quotes */
            if (text[0] == '"' && text[strlen(text) - 1] == '"')
            {
                text[strlen(text) - 1] = '\0';
                text++;
            }

            printf("%s\n", text);
        } else {
            printf("Error: unknown command: %s", line);
        }
    }

    fclose(file);

    return 0;
}