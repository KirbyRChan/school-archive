import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 Author: Kirby Chan
 Created: November 6, 2017
 Modified: December 6, 2017
 This program simulates a game in which the user guesses letters in a word. If the user guesses a letter correctly, the letter is then shown. Once all the letters have been guessed, the player wins and the game ends. If the player guesses incorectly, the bomb will tick and get closer to exploding. The player is allowed 6 incorrect guesses before the bomb explodes and the game ends.
 */

public class P4A3_CHAN_4212452
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner kbd = new Scanner(System.in);
        Random rdm = new Random();
        
        String password; //What the user is guessing
        String guess; //User's guess
        int incorrect; //Number of incorrect guesses
        int replay; //Decision to play again
        int wordNumber = -1; //Index of word in array
        boolean letterInside; //Whether or not guessed letter is in word
        boolean letterGuessed; //Whether or not guessed letter has already been guessed
        boolean win, lose; //User wins or loses the game
        
        System.out.println("Welcome specialist. You have been challenged to diffuse a bomb.\nIn order to diffuse the bomb, the secret password will have to be guessed.\nThe bomb will explode after 6 incorrect guesses. Good luck.");

        ArrayList<Character> pswdAnswer = new ArrayList<Character>(); //Character ArrayList for actual answer
        ArrayList<Character> pswdGuess = new ArrayList<Character>(); //Character ArrayList for guessed answer
        ArrayList<Character> lettersGuessedList = new ArrayList<Character>(); //Character ArrayList for all previously guessed letters
        
        ArrayList<String> wordList = new ArrayList<String>(); //String ArrayList for words to guess
        File file = new File ("P4A3_CHAN_4212452.txt"); //Opens list file
        Scanner inputFile = new Scanner(file);
        
        while (inputFile.hasNextLine()) //Inputs all words into ArrayList
        {
            wordList.add(inputFile.nextLine());
        }
        inputFile.close();
        
        Collections.shuffle(wordList); //Shuffles words in ArrayList

        do
        {
            win = lose = false; //Resets win/lose condition
            wordNumber++; //Changes
            incorrect = 0; //Sets incorrect guesses to 0 for each game
            
            password = wordList.get(wordNumber); //Sets word to a string variable
            
            String[] wordHint = password.split(","); //Splits password into the actual password and the hint
            
            for (int i = 0; i < wordHint[0].length(); i++) //Assigns password to character arrays for the actual answer and the user's answer
            {
                pswdAnswer.add(wordHint[0].charAt(i));
                pswdGuess.add('_');
            }
            
            do
            {
                letterInside = false;
                letterGuessed = false;
                
                for (int j = 0; j < wordHint[0].length(); j++) //Prints current state of guess
                {
                    System.out.print(pswdGuess.get(j) + " ");
                }
                System.out.println("\nHint: " + wordHint[1]); //Prints hint
                
                System.out.print("Guess a letter or word: "); //Prompts the user to enter a guess
                guess = kbd.nextLine();
                
                if (guess.length() == 1) //If the user guessed a letter
                {
                    for(int d = 0; d < lettersGuessedList.size(); d++) //Checks to see if the user has already guessed the inputed letter
                    {
                        if (guess.charAt(0) == lettersGuessedList.get(d))
                            letterGuessed = true;
                    }
                    
                    if (letterGuessed == false) //Continues if the letter has not been guessed already
                    {
                        for (int k = 0; k < wordHint[0].length(); k++) //Checks for guessed letter in password
                        {
                            if (pswdAnswer.get(k) == guess.charAt(0))
                            {
                                pswdGuess.set(k, guess.charAt(0));
                                letterInside = true;
                            }
                        }
                        
                        if (letterInside == true) //User guess correctly
                        {
                            System.out.println(guess + " is in the word!");
                        }
                        else //User guesses incorrectly
                        {
                            //Bomb color changes
                            incorrect++;
                            Bomb(incorrect);
                        }
                        
                        lettersGuessedList.add(guess.charAt(0)); //Adds guessed letter to ArrayList
                    }
                    if (letterGuessed == true) //If the letter has already been guessed
                    {
                        System.out.println("You have already guessed " + guess + ", try again.");
                    }
                    
                }
               
                if (guess.length() > 1) //If the user guessed a word
                {
                    if (wordHint[0].equals(guess.toLowerCase()) == false) //User guesses incorrectly
                    {
                        //Bomb color changes
                        incorrect++;
                        Bomb(incorrect);
                    }
                }
                
                //User loses if number of incorrect guesses reaches 6
                if (incorrect == 6)
                    lose = true;
                //User wins if all letters have been guessed or word has been guessed
                if (Arrays.equals(pswdAnswer.toArray(), pswdGuess.toArray()))
                    win = true;
                if (wordHint[0].equals(guess.toLowerCase()))
                    win = true;
                
            } while (win == false && lose == false); //Will continue to prompt user for a letter until they win or lose
            
            if (win) //User successfully guess word and wins
                System.out.println("You guessed the word! You won!");
            if (lose) //User guess incorrectly too many times and loses
                System.out.println("Sorry, the bomb exploded! You lost.");
            
            System.out.println("The password was: " + wordHint[0]);
            
            //Clears ArrayLists
            pswdAnswer.clear();
            pswdGuess.clear();
            lettersGuessedList.clear();
            
            System.out.print("Would you like to play again? (1)Yes or 2(No): "); //Prompts user to play again
            replay = kbd.nextInt();
            
            kbd.nextLine();
            
        } while (replay == 1); //Loops if user decides to play again
        
        System.out.println("Have a good day.");
    }
    
    public static void Bomb(int count) //Prints the color of the bomb depending on how many incorrect guesses the user has
    {
        String[] color = new String[7];
        color[0] = "none";
        color[1] = "red";
        color[2] = "orange";
        color[3] = "yellow";
        color[4] = "green";
        color[5] = "blue";
        color[6] = "PURPLE";
        System.out.println("WRONG! You have guessed incorrectly " + count + " times. The bomb is now " + color[count] + "!");
    }
    
}
