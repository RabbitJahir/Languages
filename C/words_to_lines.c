//Print each word of the sentence in a new line.

#include<stdio.h>

int main(){
    char arr[1000];
    fgets(arr, sizeof(arr), stdin);
    for (int i =0; arr[i]!='\0'; i++) // proti string er last e \0 thake, \0 = null terminator.
    {
        if (arr[i] == ' ')
            putchar('\n');
        else
            putchar(arr[i]);
    }
    return 0;}



//Print each word of the sentence in a new line.

#include<stdio.h>

int main(){
    char arr[1001],search=' ';
    fgets(arr, sizeof(arr), stdin);

     for(int i=0; arr[i]!='\0'; i++)
    {
        if(arr[i]==search)
        {
            arr[i]='\n';
        }
    }


    printf("%s",arr);

    return 0;
        }




