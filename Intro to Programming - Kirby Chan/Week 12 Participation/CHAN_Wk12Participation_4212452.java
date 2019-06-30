public class CHAN_Wk12Participation_4212452
{
	public static void main(String args[])
	{
        CHAN_Wk12Participation_4212452 car1 = new CHAN_Wk12Participation_4212452(2016, Toy Yoda)
		CHAN_Wk12Participation_4212452 car2 = new CHAN_Wk12Participation_4212452(2015, Handa)
        CHAN_Wk12Participation_4212452 car3 = new CHAN_Wk12Participation_4212452(2014, Foord)
        
        CHAN_Wk12Participation_4212452 car4 = new CHAN_Wk12Participation_4212452(car3)
        
        do (int x = 0; x < 3; x++)
        {
            car3.accelerate();
            car4.accelerate();
        }
        
        System.out.println(car1);
        System.out.println("Speed: " + car1.speed);

        System.out.println(car2);
        System.out.println("Speed: " + car2.speed);

        System.out.println(car3);
        System.out.println("Speed: " + car3.speed);

        System.out.println(car4);
        System.out.println("Speed: " + car4.speed);
        
        car4.brake();
        
        System.out.println(car1);
        System.out.println("Speed: " + car1.speed);
        
        System.out.println(car2);
        System.out.println("Speed: " + car2.speed);
        
        System.out.println(car3);
        System.out.println("Speed: " + car3.speed);
        
        System.out.println(car4);
        System.out.println("Speed: " + car4.speed);
