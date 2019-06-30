import java.util.Random;

/**
 Author: Kirby Chan
 Created: November 6, 2017
 Modified: November 11, 2017
 A Die class that can generate random rolls of a six-side die.
*/
 
public class P3A3_CHAN_DIE_4212452
{
    //Creates a random object
    Random rdm = new Random();
    
    private int die; //Value of the die
    
    //Constructor that is called
    public P3A3_CHAN_DIE_4212452()
    {
        die = 0;
    }
   
    //Mutator that changes the value of the die to a rrandom number
    public void roll()
    {
        die = rdm.nextInt(6) + 1;
    }
    
    //Accessor that returns the value of the die
    public int getValue()
    {
        return die;
    }
}
