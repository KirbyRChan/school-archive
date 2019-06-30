import java.util.Scanner;

public class WK11PARTICIPATION_CHAN_4212452
{
    public static void main(String args[])
    {
        String name;
        int idNumber;
        double rate;
        int hours;
        
        Scanner kbd = new Scanner(System.in);
        
        System.out.print("Hello, what is the name of the employee?: ");
        name = kbd.nextLine();
        
        System.out.print("What is " + name + "'s ID number?: ");
        idNumber = kbd.nextInt();
        
        WK11PARTICIPATION_PAYROLL_CHAN_4212452 employee =  new WK11PARTICIPATION_PAYROLL_CHAN_4212452(name, idNumber);
        
        System.out.print("What is " + name + "'s hourly pay rate?: ");
        rate = kbd.nextDouble();
        employee.setRate(rate);
        
        System.out.print("How many hours does " + name + " work?: ");
        hours = kbd.nextInt();
        employee.setHours(hours);
        
        System.out.println(employee.getName() + ", employee number " + employee.getID() + ", made $" + employee.grossPay() + " in gross pay.");
    }
}
        
        
        
