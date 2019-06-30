/*
 * Name:       Kirby Chan
 * Section:    01
 * Date:       03/11/2019
 * Lab:        CIS2107_Lab07_Manual
 * Goal:       To design and implement functions to process characters and strings.
 */


#include <stdio.h>
#include <memory.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

//functions
void * upperLower(const char * s);
int convertStrtoInt(const char *s1, const char *s2, const char *s3, const char *s4);
float convertStrtoFloat(const char *s1, const char *s2, const char *s3, const char *s4);
void compareStr(const char *s1, const char *s2);
void comparePartialStr(const char *s1, const char *s2, int n);
void randomize(void);
int tokenizeTelNum(char *num);
void reverse(char *text);
int countSubstr (char * line, char * sub);
int countChar (char * line, char c);
int countWords(char *string);
void countAlpha(char *string);
void startsWithB(char *string[]);
void endsWithed(char *string[]);

int main() {
    
    //random generator
    srand(time(NULL));
    
    //test for upperLower
    const char test[] = "This iS A Test";
    upperLower(test);
    
    //test for convertStrtoInt
    printf("\n\nThe sum of 4 strings is: %d", convertStrtoInt("3", "4", "5", "6"));
    
    //test for convertStrtoFloat
    printf("\n\nThe sum of 4 strings is: %.2f", convertStrtoFloat("3.5", "4.5", "5.5", "6.5"));
    
    //test for compareStr
    compareStr("Test1", "Test2");
    
    //test for comparePartialStr
    comparePartialStr("Test1", "Test2", 4);
    
    //test for randomize
    randomize();
    
    //test for tokenize number
    char str[] = "(267) 436-6281";
    tokenizeTelNum(str);
    
    //test for reverse
    char line[] = "Hello world";
    reverse(line);
    
    //test for countSubstr
    char *line1 = "helloworldworld";
    char *substring = "world";
    printf("\n\nNumber of Substrings %s inside %s: %d\n", substring, line1, countSubstr(line1, substring));
    
    //test for countChar
    char w = 'w';
    printf("\nNumber of character %c inside %s: %d\n", w, line1, countChar(line1, w));
    
    //test for countAlpha
    char str1[] = "Hello it's me.";
    countAlpha(str1);
    
    //test for countWords
    char countstring[] = "hello world!";
    printf("\n\nNumber of words in string is: %d\n", countWords(countstring));
    
    //test for startsWithB
    char *series[] = {"bored", "hello", "Brother", "manual", "bothered"};
    startsWithB(series);
    
    //test for endsWithed
    endsWithed(series);
    
}

// 1.(Displaying Strings in Uppercase and Lowercase)
void * upperLower (const char * s) {
    for (int i = 0; s[i] != '\0'; i++) {
        printf("%c", toupper(s[i]));
    }
    puts("");
    for (int i = 0; s[i] != '\0'; i++) {
        printf("%c", tolower(s[i]));
    }
    return NULL;
}

// 2.(Converting Strings to Integers for Calculations)
int convertStrtoInt(const char *s1, const char *s2, const char *s3, const char *s4) {
    int total = 0;
    total += strtol(s1, NULL, 10);
    total += strtol(s2, NULL, 10);
    total += strtol(s3, NULL, 10);
    total += strtol(s4, NULL, 10);
    
    return total;
}

//3.(Converting Strings to Floating Point for Calculations)
float convertStrtoFloat(const char *s1, const char *s2, const char *s3, const char *s4) {
    float total = 0.0;
    total += strtof(s1, NULL);
    total += strtof(s2, NULL);
    total += strtof(s3, NULL);
    total += strtof(s4, NULL);
    
    return total;
    
}

//4.(Comparing Strings)
void compareStr(const char *s1, const char *s2) {
    int cmp = strcmp(s1, s2);
    
    if (cmp == 1) {
        printf("\n\n%s is greater than %s.",s1,s2);
    }
    else if (cmp == -1) {
        printf("\n\n%s is less than %s.",s1,s2);
    }
    else {
        printf("\n\n%s is equal to %s.",s1,s2);
    }
    
}

//5.(Comparing Portions of Strings)
void comparePartialStr(const char *s1, const char *s2, int n) {
    int cmp = strncmp(s1, s2, n);
    
    if (cmp == 1) {
        printf("\n\n%s is greater than %s for the first %d characters.",s1,s2,n);
    }
    else if (cmp == -1) {
        printf("\n\n%s is less than %s for the first %d characters.",s1,s2,n);
    }
    else {
        printf("\n\n%s is equal to %s for the first %d characters.",s1,s2,n);
    }
    
}

//6.(Random Sentences)
void randomize(void) {
    char *article[] = {"the", "a", "one", "some", "any"};
    char *noun[] = {"boy", "girl", "dog", "town", "car"};
    char *verb[] = {"drove", "jumped", "ran", "walked", "skipped"};
    char *preposition[] = {"to", "from", "over", "under", "on"};
    
    puts("");
    for(int i = 0; i < 20; i++) {
        char s[40] = "";
        
        strcat(s, article[rand()%5] );
        strcat(s, " ");
        strcat(s, noun[rand()%5] );
        strcat(s, " ");
        strcat(s, verb[rand()%5] );
        strcat(s, " ");
        strcat(s, preposition[rand()%5] );
        strcat(s, " ");
        strcat(s, article[rand()%5] );
        strcat(s, " ");
        strcat(s, noun[rand()%5] );
        
        s[0] = toupper(s[0]);
        
        printf("\n%s.", s);
    }
}

//7.(Tokenizing Telephone Numbers)
int tokenizeTelNum(char *num) {
    char *a = strtok(num, "()- ");
    int area = (int) strtol(a, NULL, 10);
    
    char p[8] = "";
    strcat(p, strtok(NULL, "()- "));
    strcat(p, strtok(NULL, "()- "));
    long phone = strtol(p, NULL, 10);
    
    printf("\n\nArea-code: %d\nPhone Number: %ld",area,phone);
    
    return 0;
    
}

//8.(Displaying a Sentence with Its Words Reversed)
void reverse(char *text) {
    printf("\n\nOriginal line: %s", text);
    
    char *words[50];
    int count = 0;
    
    char *temp = strtok(text, " ");
    
    while (temp != NULL) {
        words[count++] = temp;
        temp = strtok(NULL, " ");
    }
    
    printf("\nReversedline: ");
    
    for (int i = count - 1; i >= 0; i--)
        printf("%s ", words[i]);
    
}

//9.(Counting the Occurrences of a Substring)
int countSubstr (char * line, char * sub) {
    int count = 0;
    
    const char *letter = strstr(line, sub);
    
    while(letter != NULL) {
        count++;
        letter++;
        
        letter = strstr(letter, sub);
    }
    return count;
}

//10.(Counting the Occurrences of a Character)
int countChar (char *line, char c) {
    int count = 0;
    
    char *letter = strchr(line, c);
    
    while(letter != NULL) {
        count++;
        letter++;
        
        letter = strchr(letter, c);
    }
    return count;
}


//11.(Counting the Letters of the Alphabet in a String)
void countAlpha(char *string) {
    char letter = 'A';
    int count[26];
    
    printf("\nLetter Count");
    for (int i = 0; i < 26; i++) {
        count[i] = countChar(string, letter) + countChar(string, tolower(letter));
        printf("\n%6c %5d", letter, count[i]);
        letter++;
    }
}

//12.(Counting the Number of Words in a String)
int countWords(char *string) {
    int count = 0;
    
    char *temp = strtok(string, " \n");
    
    while (temp != NULL) {
        count++;
        temp = strtok(NULL, " ");
    }
    return count;
}

//13.(Strings Starting with "b")
void startsWithB(char *string[]) {
    printf("\nStrings starting with b:\n");
    for (int i = 0; i < 6; i++) {
        char *word = string[i];
        if (tolower(word[0]) == 'b') {
            printf("%s\n",word);
        }
    }
}

//14.(Strings Ending with "ed")
void endsWithed(char *string[]) {
    printf("\nStrings ending with ed:\n");
    for (int i = 0; i < 6; i++) {
        char *word = string[i];
        int len = (int) strlen(word);
        if (tolower(word[len-2]) == 'e' && tolower(word[len-1]) == 'd') {
            printf("%s\n",word);
        }
    }
}
