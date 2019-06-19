#include <stdio.h>
#include <time.h>

int main() {

    time_t sec;
    char* current_time;
    struct tm t;

    // time.h time()
    sec = time(NULL);
    printf("Time in Second : %ld \n", sec);

    // time.h ctime(sec) in format like "Sun Jun 16 11:37:12 2019"
    current_time = ctime(&sec);
    printf("Time in CTime : %s \n", current_time);

    // time.h astime() in struct tm
    current_time = asctime(localtime(&sec));
    printf("Time in ASCTime : %s \n", current_time);

    return 0;
}