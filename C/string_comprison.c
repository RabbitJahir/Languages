#include <stdio.h>
#include <string.h>

int main()
{

    char *correct[] = {"vertebrado", "ave", "onivoro", "invertebrado", "inseto", "hematofago"};
    char one[20], two[20], three[20];
    fgets(one, sizeof(one), stdin);
    one[strcspn(one, "\n")] = '\0';
    fgets(two, sizeof(two), stdin);
    two[strcspn(two, "\n")] = '\0';
    fgets(three, sizeof(three), stdin);
    three[strcspn(three, "\n")] = '\0';

    if (strcmp(one, correct[0]) == 0)
    {
        if (strcmp(two, correct[1]) == 0)
        {
            if (strcmp(three, correct[2]) == 0)
                printf("pomba\n");
            else
                printf("aguia\n");
        }
        else
        {
            if (strcmp(three, correct[2]) == 0)
                printf("homen\n");
            else
                printf("vaca\n");
        }
    }
    if (strcmp(one, correct[3]) == 0)
    {
        if (strcmp(two, correct[4]) == 0)
        {
            if (strcmp(three, correct[5]) == 0)
                printf("pulga\n");
            else
                printf("lagarta\n");
        }
        else
        {
            if (strcmp(three, correct[5]) == 0)
                printf("sanguessuga\n");
            else
                printf("minhoca\n");
        }
    }

    return 0;
}
