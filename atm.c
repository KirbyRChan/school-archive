// Kirby Chan
// 2/4/19
// CIS2107 Computer Systems and Low-Level Programming
// Lab 03 ATM Machine
// Imitates a few of the uses that can be found in an ATM machine.

#include <stdio.h>
#include <stdlib.h>
void balance(void);
void withdraw(void);
void deposit(void);
void quit(void);

static int bal = 5000;
static int trans = 0;
static int wthdrwTotal = 0;
static int dpstTotal = 0;

int main(void) {
    
    int pin = 3024;
    int attempt;
    printf("%s","Hello, Nana! Welcome to the ATM.\n\tPlease enter your PIN: ");
    
    int tries = 0;
    do {
        tries++;
        scanf("%d",&attempt);
        if (pin != attempt) {
            if (tries < 3) {
                printf("%s", "Incorrect PIN. Please try again: ");
            }
            else {
                printf("You have used up all your attempts. Have a good day.\n");
                exit(0);
            }
        }
    } while (pin != attempt);
    
    if (pin != attempt && tries == 3) {
            printf("You have used up all your attempts. Have a good day.\n");
            exit(0);
    }
    
    int action = 0;
    while (action != 4) {
        printf("What would you like to do?\n\t(1)Check Balance\n\t(2)Cash Withdrawal\n\t(3)Cash Deposition\n\t(4)Quit\n");
        scanf("%d", &action);
        switch(action) {
            case 1:
                balance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                quit();
                break;
            default:
                printf("Please enter a valid number.\n");
        }
    }
}

void balance(void) {
    printf("Your balance is: $%d\n", bal);
    trans++;
}
void withdraw(void) {
    int wthdrw;
    printf("%s", "How much would you like to withdraw (You may only withdraw in multiples of 20)?: ");
    scanf("%d", &wthdrw);
    if (wthdrw+wthdrwTotal>1000) {
        printf("You may not withdraw more than $1,000 per day. You have already withdrew $%d today.\n",wthdrwTotal);
    }
    else if( wthdrw%20 != 0) {
        printf("$%d is not a multiple of 20.\n",wthdrw);
    }
    else if(wthdrw > bal) {
        printf("You only have $%d in your account.",bal);
    }
    else {
        wthdrwTotal += wthdrw;
        bal -= wthdrw;
        printf("You have successfully withdrew $%d. Your balance is now at $%d.\nWould you like to keep a receipt?\n\t(1)Yes\n\t(2)No\n",wthdrw,bal);
        int yn;
        scanf("%d", &yn);
        if (yn == 1) {
            printf("A receipt has been saved.\n");
            
        }
        trans++;
    }
}
void deposit(void) {
    int dpst;
    printf("%s", "How much would you like to deposit?: ");
    scanf("%d", &dpst);
    if (dpst+dpstTotal>10000) {
        printf("You may not deposit more than $10,000 per day. You have already deposited $%d today.\n",dpstTotal);
    }
    else {
        dpstTotal += dpst;
        bal += dpst;
        printf("You have successfully deposited $%d. Your balance is now at $%d.\nWould you like to keep a receipt?\n\t(1)Yes\n\t(2)No\n",dpst,bal);
        
        int yn;
        scanf("%d", &yn);
        if (yn == 1) {
            printf("A receipt has been saved.\n");
        }
        trans++;
    }
}
void quit(void) {
    printf("Thank you for using the ATM. You performed a total of %d transactions. Please come again.\n",trans);
    exit(0);
}
