// Kirby Chan
// CIS2107 Computer Systems and Low-Level Programming
// 2/25/19
// Race

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

#define RACE 70

int tortMove(int tort);
int hareMove(int hare);
void printRace(int hare, int tort);
void victoryMsg(int hare, int tort);

int main(void) {
    
    srand(time(NULL));
    
    int harePlace = 0;
    int tortPlace = 0;
    
    puts("ON YOUR MARK, GET SET");
    sleep(1);
    puts("BANG !!!!!");
    sleep(1);
    puts("AND THEY'RE OFF !!!!!");
    
    while(harePlace < RACE-1 && tortPlace < RACE-1) {
        tortPlace = tortMove(tortPlace);
        harePlace = hareMove(harePlace);
        printRace(harePlace, tortPlace);
    }
    
    victoryMsg(harePlace, tortPlace);
    
    return 0;
}

int tortMove(int tort) {
    int move = rand()%10 + 1;
    
    if(move <= 5) {
        move = 3;
    }
    else if(move <= 7) {
        move = -6;
    }
    else {
        move = 1;
    }
    
    if(tort+move >= RACE) {
        return RACE-1;
    }
    else if(tort+move < 0) {
        return 0;
    }
    else {
        return tort+move;
    }
    
}

int hareMove(int hare) {
    int move = rand()%10 + 1;
    
    if (move <= 2) {
        move = 0;
    }
    else if (move <= 4) {
        move = 9;
    }
    else if (move <= 5) {
        move = -12;
    }
    else if (move <= 8){
        move = 1;
    }
    else {
        move = -2;
    }
    
    if(hare+move >= RACE) {
        return RACE-1;
    }
    else if(hare+move < 0) {
        return 0;
    }
    else {
        return hare+move;
    }
}

void printRace(int hare, int tort) {

    for(int i = 0; i < RACE; i++) {
        if (hare == tort && i == hare) {
            printf("%s","OUCH!!!");
        }
        else if(i == hare) {
            printf("%s", "H");
        }
        else if(i == tort) {
            printf("%s", "T");
        }
        else {
            printf("%s", " ");
        }
    }
    puts("");
    sleep(1);
}

void victoryMsg(int hare, int tort) {
    if (hare == RACE-1 && tort == RACE-1) {
        puts("It's a tie. Boo.");
    }
    else if(tort == RACE-1) {
        puts("TORTOISE WINS!!! YAY!!!");
    }
    else {
        puts("Hare wins. Yuch.");
    }
}
