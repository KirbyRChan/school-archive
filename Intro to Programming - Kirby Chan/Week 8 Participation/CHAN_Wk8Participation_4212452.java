import javax.swing.JOptionPane;

/**
 Author: Kirby Chan
 Created: October 17, 2017
 Modified: October 19, 2017
*/

public class CHAN_Wk8Participation_4212452
{
    public static void main(String[] args)
    {
        String Name;
        String numInput;
        int total;
        
        Name = JOptionPane.showInputDialog("Hello, please enter your name.");
        welcome(Name);
        
        numInput = JOptionPane.showInputDialog("Please enter a number.");
        int num1 = Integer.parseInt(numInput);
        
        numInput = JOptionPane.showInputDialog("Please enter another number.");
        int num2 = Integer.parseInt(numInput);
        
        total = sum(num1, num2);
        
        JOptionPane.showMessageDialog(null, String.format("The sum of " + num1 + " and " + num2 + " is:\n" + total));
    }
        
    public static void welcome(String name)
    {
        JOptionPane.showMessageDialog(null, String.format("Welcome " + name + ", this program will allow you to add together two numbers."));
    }
    
    public static int sum(int number1, int number2)
    {
        int summation = number1 + number2;
        return summation;
    }
}
