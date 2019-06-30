//  Kirby Chan
//  Computer Systems and Low-Level Programming
//  Feb 11, 2019
//  Arrays1DDemo
//  Modify a 1D array using different functions

#include <stdio.h>
#include <stdlib.h>
#define SIZE 40

void fillArray(int b[]);
int findwithRange(int b[], int low, int high);
void reverseArray(int b[]);
void reverseArrayRange(int b[], int low, int high);
int findSequence(int b[], int first, int second);

int main(void) {

    int a[SIZE];

    fillArray(a);
    puts("fillArray Test");
    for (size_t i = 0; i <SIZE; i++) {
        printf("%d ", a[i]);
    }
    puts("\n\nfindwithRange Test");
    puts("Max from index 0 to 10");
    int index = findwithRange(a, 0, 10);
    for (size_t i = 0; i <= 10; i++) {
        printf("%d ", a[i]);
    }
    printf("\nMax = %d at index = %d", a[index], index);
    
    puts("\n\nreverseArray Test");
    reverseArray(a);
    for (size_t i = 0; i <SIZE; i++) {
        printf("%d ", a[i]);
    }
    
    puts("\n\nreverseArrayRange Test");
    reverseArrayRange(a, 0, 10);
    puts("Reversed from index 0 to 10");
    for (size_t i = 0; i <= 10; i++) {
        printf("%d ", a[i]);
    }
    
    puts("\n\nfindSequence Test");
    int first, second;
    printf("%s","Enter two numbers: ");
    scanf("%d %d", &first, &second);
    int seq = findSequence(a, first, second);
    if (seq==-1) {
        puts("Sequence not found");
    }
    else {
        printf("Sequence found at index %d\n", seq);
    }
    
    return 0;
}

void fillArray(int b[]) {
    for (size_t i = 0; i < SIZE; i++) {
        b[i] = rand()%101;
    }
    
}
int findwithRange(int b[], int low, int high) {
    while (low<0 || high>SIZE || low>high) {
        puts("Index Error. Please enter new values for low and high.");
        printf("%s","Low: ");
        scanf("%d", &low);
        printf("%s","High: ");
        scanf("%d", &high);
    }
    int max = 0;
    int maxIndex = 0;
    for (size_t i = low; i<=high; i++) {
        if (b[i]>max) {
            max = b[i];
            maxIndex = (int)i;
        }
    }
    return maxIndex;
}
void reverseArray(int b[]) {
    int temp;
    int low = 0;
    int high = SIZE-1;
    while (low < high) {
        temp = b[low];
        b[low] = b[high];
        b[high] = temp;
        low++;
        high--;
    }
}
void reverseArrayRange(int b[], int low, int high) {
    while (low<0 || high>SIZE || low>high) {
        puts("Index Error. Please enter new values for low and high.");
        printf("%s","Low: ");
        scanf("%d", &low);
        printf("%s","High: ");
        scanf("%d", &high);
    }
    int temp;
    while (low < high) {
        temp = b[low];
        b[low] = b[high];
        b[high] = temp;
        low++;
        high--;
    }
}
int findSequence(int b[], int first, int second) {
    for(size_t i = 0; i < SIZE-1; i++) {
        if (b[i]==first && b[i+1]==second) {
            return (int)i;
        }
    }
    return -1;
}
