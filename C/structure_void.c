#include <stdio.h>
#include <stdbool.h>

typedef struct{   //structure, typedef:�Hey compiler, whenever I write Student, I mean this specific struct.�
    char name[50];
    int age;
    float gpa;
    bool isfulltime; //bool true, false

}Student;

void printstudent(Student s); //C upor theke niche and left to right, code read kore

int main() {
   Student s1= {"Hosbo yo", 21, 5.9, false};  //Student hoche struct and s1 hoche varibale
   Student s2= {"Hosb ?", 22, 5.1, false};
   Student s3= {"Ho1 so2", 20, 1.9, false};
   Student s4= {"Hooooooooooooooooooooo", 46, 0.9, true};

   
   printstudent(s1);
   printstudent(s2);
   printstudent(s3);
   printstudent(s4);

    return 0;
}

void printstudent(Student s){ //Student hoche struct er type, and s assigner korbe, je struct er data koi paste hobe.
    printf("%s\n", s.name); // . use kore struct er bhitore individually access er jonne
    printf("%d\n", s.age);
    printf("%.2f\n", s.gpa);
    printf("%s\n", (s.isfulltime)? "yes": "no" );
    printf("\n");
}
