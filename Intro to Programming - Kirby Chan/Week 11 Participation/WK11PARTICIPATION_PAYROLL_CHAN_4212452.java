public class WK11PARTICIPATION_PAYROLL_CHAN_4212452
{
    private String name;
    private int idNumber;
    private double rate;
    private int hours;
    
    public WK11PARTICIPATION_PAYROLL_CHAN_4212452(String user, int ID)
    {
    name = user;
    idNumber = ID;
    rate = 0.0;
    hours = 0;
    }
   
    public void setName(String user)
    {
        name = user;
    }
    
    public void setID(int ID)
    {
        idNumber = ID;
    }
    
    public void setRate(double payRate)
    {
        rate = payRate;
    }
    
    public void setHours(int workHour)
    {
        hours = workHour;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    public int getID()
    {
        return idNumber;
    }
    
    public double getRate()
    {
        return rate;
    }
    
    public int getHour()
    {
        return hours;
    }
    public double grossPay()
    {
        double a = rate * hours;
        double gross = Math.round(a * 100.0) / 100.0;
        return gross;
    }
}
