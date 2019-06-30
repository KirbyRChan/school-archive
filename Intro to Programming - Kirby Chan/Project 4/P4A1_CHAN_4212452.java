import java.util.Arrays;
import java.util.Scanner;

/**
 Author: Kirby Chan
 Created: November 20, 2017
 Modified: December 6, 2017
 This program simulates a game in which the user guesses letters in a word. If the user guesses a letter correctly, the letter is then shown. Once all the letters have been guessed, the player wins and the game ends. If the player guesses incorecctly, the bomb will tick and get closer to exploding. The player is allowed 6 incorrect guesses before the bomb explodes and the game ends.
 */

public class P4A1_CHAN_4212452
{
    public static void main(String[] args)
    {
        Scanner kbd = new Scanner(System.in);

        char guess; //User's guess
        boolean correct; //Whether or not guess is in word
        int number = 0; //Number of incorrect guesses
        
        System.out.println("Welcome specialist. You have been challenged to diffuse a bomb.\nIn order to diffuse the bomb, the secret password will have to be guessed.\nThe bomb will explode after 6 incorrect guesses. Good luck.");
        
        String password = "pancake"; //What the user is guessing
        
        char[] pswdAnswer = new char[password.length()]; //Character array for actual answer
        char[] pswdGuess = new char[password.length()]; //Character array for guessed answer
        
        for (int i = 0; i < password.length(); i++) //Assigns password to the character arrays
        {
            pswdAnswer[i] = password.charAt(i);
            pswdGuess[i] = '_';
        }
        
        do
        {
            correct = false;
            
            for (int j = 0; j < password.length(); j++) //Prints currrent state of guess
            {
                System.out.print(pswdGuess[j] + " ");
            }
            
            System.out.print("\nGuess a letter: "); //Prompts the user to enter a letter
            guess = kbd.nextLine().charAt(0);
            
            for (int k = 0; k < password.length(); k++)
            {
                if (pswdAnswer[k] == guess) //Checks for guessed letter in the password
                {
                    pswdGuess[k] = guess;
                    correct = true;
                }
            }
            
            if (correct == true) //User guesses correctly
            {
                System.out.println(guess + " is in the word!");
            }
            else //User guesses incorrectly
            {
                number++; //Adds 1 to number of incorrect guesses
                Bomb(number); //Calls Bomb method
            }
            
        } while (number < 6 && Arrays.equals(pswdAnswer, pswdGuess) == false); //Will continue to prompt user for a letter until they win or lose
        
        if (number == 6) //User guesses incorrectly too many times and loses
            System.out.println("Sorry, the bomb exploded! You lost.\nThe password was: " + password);
        if (Arrays.equals(pswdAnswer, pswdGuess)) //User successfully guess word and wins
            System.out.println("You guessed the word! You won!\nThe password was: " + password);
        
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
