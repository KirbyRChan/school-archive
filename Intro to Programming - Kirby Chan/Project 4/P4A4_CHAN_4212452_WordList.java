import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 Author: Kirby Chan
 Created: December 7, 2017
 Modified: December 7, 2017
 A word list class that can add and get words from a list of words.
*/
 
public class P4A4_CHAN_4212452_WordList
{
    //Initialize the ArrayList
    private ArrayList<String> list;
    
    //Constructor that is called if no file is specified
    public P4A4_CHAN_4212452_WordList() throws FileNotFoundException
    {
        //Declares the ArrayList
        list = new ArrayList<String>();
    }
    //Constructor that is called if a file is specified
    public P4A4_CHAN_4212452_WordList(String txt) throws FileNotFoundException
    {
        list = new ArrayList<String>();
        File file = new File(txt); //Opens list file
        Scanner inputFile = new Scanner(file);
        
        while (inputFile.hasNextLine()) //Inputs all words into ArrayList
        {
            list.add(inputFile.nextLine());
        }
        inputFile.close();
    }
   
    //Adds a word to the object
    public void addWord(String word)
    {
        list.add(word);
    }
    
    //Adds all words from a file to the object
    public void addWordsFromFile(String txt) throws FileNotFoundException
    {
        File file = new File(txt); //Opens list file
        Scanner inputFile = new Scanner(file);
        
        while (inputFile.hasNextLine()) //Inputs all words into ArrayList
        {
            list.add(inputFile.nextLine());
        }
        inputFile.close();
    }
    
    //Returns a random word from the object
    public String getRandomWord()
    {
        Random rdm = new Random();
        int randomNumber = rdm.nextInt(list.size());
        return list.get(randomNumber);
    }
    
    //Returns the number of words in the object
    public int numWords()
    {
        return list.size();
    }

}
