#include <stdio.h>
#include <time.h>

int main() {
    time_t now; //time_t: has the current time and date in integer value
    time(&now); // assings the time to the variable

    struct tm *local = localtime(&now);
    int hour = local->tm_hour;

    printf("Current time: %s", ctime(&now)); //ctime: current time, but user readeable

    if (hour>=10) {
    printf("It's already past 10 bro...\n");
} else if (hour >= 12) {
    printf("ya too high , go sleep.\n");
} else if (hour >=1 ) {
    printf("seriously. still awake.?\n");
} else if (hour >=2 ) {
    printf("tf is wrong with you.\n");
} else if (hour >=3 ) {
    printf(".\n");
} else if (hour >=5 ) {
    printf("why even bother sleeping.\n");
} else {
    printf("its not night");
}


    return 0;

}
