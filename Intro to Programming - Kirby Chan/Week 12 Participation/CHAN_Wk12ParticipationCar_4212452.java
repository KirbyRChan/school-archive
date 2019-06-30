public class CHAN_Wk12ParticipationCar_4212452
{
	private int year;
	private String make;
	private int speed;
	private static int instanceNo = 0;
	
	public CHAN_Wk12ParticipationCar_4212452(int yr, String mk)
	{
		year = yr;
		make = mk;
		speed = 0;
		instanceNo++;
	}
	public CHAN_Wk12ParticipationCar_4212452(CHAN_Wk12ParticipationCar_4212452 object2)
	{
		year = copy.year();
		model = copy.model();
		speed = copy.speed();
		instanceNo++;
	}
	
	public int year()
	{
		return year;
	}
	public String make()
	{
		return make;
	}
	public int speed()
	{
		return speed;
	}
	
	public void accelerate()
	{
		speed += 5;
	}
	public void brake()
	{
		speed -= 5;
	}
    
    public boolean equals(CHAN_Wk12ParticipationCar_4212452 object2)
    {
        boolean status;
        if (year.equals(object2.year) && model.equals(object2.model))
            status = true;
        else
            status = false;
        return status;
    }
    public int fastest(CHAN_Wk12ParticipationCar_4212452 object2)
    {
        int fast = speed.compareTo(object.speed);
        return fast;
    }
    public String toString()
    {
        String str = "Make: " + make + "\nYear: " + year;
        return str;
    }
	
