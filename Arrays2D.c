// Kirby Chan
// 2/18/19
// CIS2107 Computer Systems and Low Level Programming
// Arrays2D

#include <stdio.h>

int max(int row, int col, int array[row][col]);
int rowSum(int row, int col, int array[row][col], int srow);
int columnSum(int row, int col, int array[row][col], int scol);
void isSquare(int row, int col);
void displayOutputs(int row, int col, int array[row][col]);

int main(void) {
    printf("Let's create a 2Dim Array!\n\n");
    
    int row;
    printf("%s","\tHow many rows? ");
    scanf("%d",&row);
   
    int col;
    printf("%s","\tHow many columns? ");
    scanf("%d",&col);
    
    int array2D[row][col];
    
    puts("");
    for (int i=0; i<row; i++) {
        for (int j=0; j<col; j++) {
            int value;
            printf("\tEnter [%d][%d]: ", i, j);
            scanf("%d", &value);
            array2D[i][j] = value;
        }
    }
    puts("");
    
    printf("Max value is %d.\n", max(row, col, array2D));
    
    puts("");
    
    for(int i=0; i<row; i++) {
        printf("Sum of row %d = %d\n", i, rowSum(row, col, array2D, i) );
    }
    for(int j=0; j<col; j++) {
        printf("Sum of column %d = %d\n", j, columnSum(row, col, array2D, j) );
    }
    
    puts("");
    
    isSquare(row, col);
    
    puts("Here is your 2Dim array: ");
    displayOutputs(row, col, array2D);
    
    
    return 0;
}
int max(int row, int col, int array[row][col]) {
    int maxVal = array[0][0];
    for (size_t i=0; i<row; i++) {
        for (size_t j=0; j<col; j++) {
            if (maxVal < array[i][j]) {
                maxVal = array[i][j];
            }
        }
    }
    return maxVal;
}

int rowSum(int row, int col, int array[row][col], int srow) {
    int sum = 0;
    for (size_t j=0; j<col; j++) {
        sum += array[srow][j];
    }
    return sum;
}
int columnSum(int row, int col, int array[row][col], int scol) {
    int sum = 0;
    for (size_t i=0; i<row; i++) {
        sum += array[i][scol];
    }
    return sum;
}
void isSquare(int row, int col) {
    if (row == col) {
        puts("This is a square array.\n");
    }
    else {
        puts("This is not a square array.\n");
    }
}
void displayOutputs(int row, int col, int array[row][col]) {
    for (size_t i=0; i<row; i++) {
        printf("%s","[");
        for (size_t j=0; j<col; j++) {
            if (j==col-1) {
                printf("%d", array[i][j]);
            }
            else {
                printf("%d, ", array[i][j]);
            }
        }
        printf("%s","]\n");
    }
}
