// Kirby Chan
// 2/13/19
// CIS2107 Computer Systems and Low Level Programming
// quiz2q2


#include <stdio.h>
#include <stdlib.h>

int splitIntoDate(int days) {
    int year, week, day;
    year= days / 365;
    week = (days%365) / 7;
    day = (days%365)%7;
    printf("Number of years is %d, weeks is %d, and days is %d.\n", year, week, day);
    return 0;
}

int main() {
    int days;
    printf("%s","Please write number of days: ");
    scanf("%d", &days);
    splitIntoDate(days);
}
