// Kirby Chan
// 1/28/2019
// CIS2107 Computer SYstems and Low Level Programming
// Lab 02 Paycheck and Revenue
// The goal is to calculate and display the pay for an employee based on their hours and salary

#include <stdio.h>
#include <stdlib.h>

int main (void)
{
    printf("Welcome to \"TEMPLE HUMAN RESOURCES\"\n\n");
    
    int num;  
    printf("\t%s","Enter Employee Number: "); //Obtain employee number
    scanf("%d", &num);
    if (num <= 0) //Check if employee number is valid
    {
        printf("\n\tThis is not a valid Employee Number.\n\tPlease run the program again\n\nThank you for using \"TEMPLE HUMAN RESOURCES\"\n");
        exit(0);
    }
    int sal;
    printf("\t%s","Enter Hourly Salary: "); //Obtain salary
    scanf("%d", &sal);
    if (sal <= 0) //Check if salary is valid
    {
        printf("\n\tThis is not a valid hourly salary amount.\n\tPlease run the program again\n\nThank you for using \"TEMPLE HUMAN RESOURCES\"\n");
        exit(0);
    }
    int time;
    printf("\t%s","Enter Weekly Time: "); //Obtain weekly time
    scanf("%d", &time);
    if (time <= 0)  //Check if weekly time is valid
    {
        printf("\n\tThis is not a weekly time.\n\tPlease run the program again\n\nThank you for using \"TEMPLE HUMAN RESOURCES\"\n");
        exit(0);
    }
    
    printf("==============================\n");
    
    printf("\tEmployee #: %d\n",num);
    
    printf("\tHourly Salary: $%.2f\n", (float)sal);
           
    printf("\tWeekly Time: %.2f\n", (float)time);
     
    float reg;
    float over;
     
    if (time <= 40)   //Checks if weekly time is over 40. If so, calculate the overtime pay
    {
        reg = (float)time*sal;
        over = 0.0;
    }
    else
    {
        reg = (float)sal*40;
        over = (float)sal*(time-40)*1.5;
    }
     
    printf("\tRegular Pay: $%.2f\n",reg);
     
    printf("\tOvertime Pay: $%.2f\n",over);
    
    float net = (float)reg+over;
    printf("\tNet Pay: $%.2f\n",net);
           
    printf("==============================\n");
    printf("%s","Thank you for using \"TEMPLE HUMAN RESOURCES\"\n");
    exit(0);
}
