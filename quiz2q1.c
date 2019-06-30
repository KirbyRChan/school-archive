// Kirby Chan
// 2/13/19
// CIS2107 Computer Systems and Low Level Programming
// quiz2q1

#include <stdio.h>

int sumEverySecondNumber(int low, int high) {
    int sum = 0;
    int i;
    for (i = low; i<=high; i+=2) {
        sum += i;
    }
    return sum;
}

int main() {
    int n;
    printf("%s","Please give N: ");
    scanf("%d", &n);
    printf("Sum of odd numbers is: %d\n", sumEverySecondNumber(1,n));
    printf("Sum of even numbers is: %d\n", sumEverySecondNumber(0,n));
}
