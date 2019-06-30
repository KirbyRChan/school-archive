import java.util.Scanner;
import java.io.*;

/**
 Author: Kirby Chan
 Created: October 3, 2017
 Modified: October 5, 2017
*/

public class CHAN_Wk6Participation_4212452
{
    public static void main(String[] args) throws IOException
	{
        int numberFriends;
        String fileName;
        String friendName;
        int Decision;
        
        Scanner kbd = new Scanner(System.in);
        
        System.out.print("Enter the name for your file: ");
        fileName = kbd.nextLine();
        
        PrintWriter outputFile = new PrintWriter(fileName);
        do
        {
            
        System.out.print("How many friends would you like to add? : ");
            numberFriends = kbd.nextInt();
        
            kbd.nextLine();
            
            for (int i = 1; i <= numberFriends; i++)
            {
                System.out.print("What is the name of friend " + i +"? : ");
                friendName = kbd.nextLine();
            
                outputFile.println(friendName);
            }
            System.out.print("Would you like to add more friends? (1)Yes (2)No: ");
            Decision = kbd.nextInt();
            
        } while (Decision == 1);
        
        outputFile.close();
        System.out.println("Data saved to file.");
    }
}
        
        
