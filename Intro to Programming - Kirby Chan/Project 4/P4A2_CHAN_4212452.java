import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 Author: Kirby Chan
 Created: November 27, 2017
 Modified: December 6, 2017
 This program simulates a game in which the user guesses letters in a word. If the user guesses a letter correctly, the letter is then shown. Once all the letters have been guessed, the player wins and the game ends. If the player guesses incorecctly, the bomb will tick and get closer to exploding. The player is allowed 6 incorrect guesses before the bomb explodes and the game ends.
 */

public class P4A2_CHAN_4212452
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner kbd = new Scanner(System.in);
        
        String password; //What the user is guessing
        char guess; //User's guess
        int incorrect; //Number of incorrect guesses
        int replay; //Decision to play again
        int wordNumber = -1; //Index of word in array
        boolean correct; //Whether or not guess is in word
        
        System.out.println("Welcome specialist. You have been challenged to diffuse a bomb.\nIn order to diffuse the bomb, the secret password will have to be guessed.\nThe bomb will explode after 6 incorrect guesses. Good luck.");

        ArrayList<Character> pswdAnswer = new ArrayList<Character>(); //Character ArrayList for actual answer
        ArrayList<Character> pswdGuess = new ArrayList<Character>(); //Character ArrayList for guessed answer
    
        ArrayList<String> wordList = new ArrayList<String>(); //String ArrayList for words to guess
        File file = new File ("P4A2_CHAN_4212452.txt"); //Opens list file
        Scanner inputFile = new Scanner(file);
        
        while (inputFile.hasNextLine()) //Inputs all words into ArrayList
        {
            wordList.add(inputFile.nextLine());
        }
        inputFile.close();
        
        Collections.shuffle(wordList); //Shuffles words in ArrayList

        do
        {
            wordNumber++; //Changes password for each game
            incorrect = 0; //Sets incorrect guesses to 0 for each game
            
            password = wordList.get(wordNumber); //Sets word to a string variable
            
            for (int i = 0; i < password.length(); i++) //Assigns password to character arrays for the actual answer and the user's guessed answer
            {
                pswdAnswer.add(password.charAt(i));
                pswdGuess.add('_');
            }
            
            do
            {
                correct = false;
                
                for (int j = 0; j < password.length(); j++) //Prints current state of guess
                {
                    System.out.print(pswdGuess.get(j) + " ");
                }
                
                System.out.print("\nGuess a letter: "); //Prompts the user to enter a guess
                guess = kbd.nextLine().charAt(0);
                
                for (int k = 0; k < password.length(); k++) //Checks for guessed letter in password
                {
                    if (pswdAnswer.get(k) == guess) //Replaces '_' in guessed answer to actual letter if guessed correctly
                    {
                        pswdGuess.set(k, guess);
                        correct = true;
                    }
                }
                
                if (correct == true) //User guess correctly
                {
                    System.out.println(guess + " is in the word!");
                }
                else //User guesses incorrectly
                {
                    //Bomb color changes
                    incorrect++;
                    Bomb(incorrect);
                }
                
            } while (incorrect < 6 && Arrays.equals(pswdAnswer.toArray(), pswdGuess.toArray()) == false); //Will continue to prompt user for a letter until they win or lose
            
            if (incorrect == 6) //User guess incorrectly too many times and loses
                System.out.println("Sorry, the bomb exploded! You lost.\nThe password was: " + password);
            if (Arrays.equals(pswdAnswer.toArray(), pswdGuess.toArray())) //User successfully guess word and wins
                System.out.println("You guessed the word! You won!\nThe password was: " + password);
            
            
            for (int u = 0; u < password.length(); u++) //Clears ArrayLists
            {
                pswdAnswer.remove(0);
                pswdGuess.remove(0);
            }
        
            System.out.print("Would you like to play again? (1)Yes or 2(No): "); //Prompts user to play again
            replay = kbd.nextInt();
            
            kbd.nextLine();
            
        } while (replay == 1); //Loops if user decides to play again
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

