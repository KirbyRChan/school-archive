// Kirby Chan
// 2/18/19
// CIS2107 Computer Systems and Low Level Programming
// ArraysofPointers

#include <stdio.h>
#include <stdlib.h>

#define STUDENTS 3
#define EXAMS 4

void minimum(const int grades[][EXAMS], size_t pupils, size_t tests);
void maximum(const int grades[][EXAMS], size_t pupils, size_t tests);
void average(const int grades[][EXAMS], size_t pupils, size_t tests);
void printArray(const int grades[][EXAMS], size_t pupils, size_t tests);



int main(void) {
    
    void (*f[4])(const int [][EXAMS], size_t, size_t) = {minimum, maximum, average, printArray};
    
    int studentGrades[STUDENTS][EXAMS] =
    {   { 77, 68, 86, 73 },
        { 96, 87, 89, 78 },
        { 70, 90, 86, 81 }  };
   
    int choice = 0;
    while (choice != 4) {
        printf("\nEnter a choice:\n\t 0 Print the array of grades\n\t 1 Find the minimum grade\n\t 2 Find the maximum grade\n\t 3 Print the average on all tests for each student\n\t 4 End program\n");
        scanf("%d", &choice);
        switch(choice) {
            case 0:
                printArray(studentGrades, STUDENTS, EXAMS);
                break;
            case 1:
                minimum(studentGrades, STUDENTS, EXAMS);
                break;
            case 2:
                maximum(studentGrades, STUDENTS, EXAMS);
                break;
            case 3:
                average(studentGrades, STUDENTS, EXAMS);
                break;
            case 4:
                break;
            default:
                puts("Please enter a valid choice.");
        }
    }
}

void minimum(const int grades[][EXAMS], size_t pupils, size_t tests) {
    
    int lowGrade = 100;
    
    for (size_t i = 0; i < pupils; i++) {
        for (size_t j=0; j< tests; j++) {
            if (grades[i][j] < lowGrade) {
                lowGrade = grades[i][j];
            }
        }
    }
    printf("\nLowest grade: %d\n", lowGrade);
}

void maximum(const int grades[][EXAMS], size_t pupils, size_t tests) {
    
    int highGrade = 0;
    
    for (size_t i = 0; i < pupils; i++) {
        for (size_t j=0; j< tests; j++) {
            if (grades[i][j] > highGrade) {
                highGrade = grades[i][j];
            }
        }
    }
    printf("\nHighest grade: %d\n", highGrade);
}

void average (const int grades[][EXAMS], size_t pupils, size_t tests) {
    
    int total;
    
    for (size_t i = 0; i < pupils; i++) {
        total = 0;
        
        for (size_t j = 0; j < tests; j++) {
            total += grades[i][j];
        }
        
        printf("The average grade for student %zu is %.2f\n",
               i, (double)total/tests);
    }
}

void printArray (const int grades[][EXAMS], size_t pupils, size_t tests) {
    
    puts("The array is:");
    
    printf("%s", "                [0]  [1]  [2]  [3]");
    
    for (size_t i = 0; i < pupils; i++) {
        printf("\nstudentGrades[%zu] ", i);
        
        for (size_t j = 0; j < tests; j++) {
            printf("%-5d", grades[i][j]);
        }
    }
    puts("");
}
