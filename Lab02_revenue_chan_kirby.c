// Kirby Chan
// 1/28/2019
// CIS2107 Computer SYstems and Low Level Programming
// Lab 02 Paycheck and Revenue
// The goal is to calculate costs based on item price, item quantity, and discounts applied

#include <stdio.h>
#include <stdlib.h>

int main (void)
{
    printf("Welcome to \"Temple\" Store\n\n");
    
    int price;
    printf("\t%s","Enter item price: ");
    scanf("%d", &price);
    if (price <= 0)
    {
        printf("\n\tThis is not a valid item price.\n\tPlease run the program again\n\nThank you for using \"Temple\" Store\n");
        exit(0);
    }
    
    int quant;
    printf("\t%s","Enter quantity: ");
    scanf("%d", &quant);
    if (quant <= 0)
    {
        printf("\n\tThis is not a valid quantity order.\n\tPlease run the program again\n\nThank you for using \"Temple\" Store\n");
        exit(0);
    }
    
    printf("\tThe item price is: $%.2f\n",(float)price);
    
    printf("\tThe order is: %d item(s)\n", quant);
    
    float cost = (float)price*quant;
    printf("\tThe cost is: $%.2f\n",cost);
    
    float disc;
    if(quant >= 150)
        disc = 25.0;
    else if(quant >= 100)
        disc = 15.0;
    else if(quant>= 50)
        disc = 10.0;
    else
        disc = 0.0;
    printf("\tThe discount is: %.2f%%\n",disc);
    
    float discAmt = cost*(disc/100);
    printf("\tThe discount amount is: $%.2f\n", discAmt);
    
    float total = cost-discAmt;
    printf("\tThe cost is: $%.2f\n", total);
    
    printf("\nThank you for using \"Temple\" Store\n");
    exit(0);
}
