import java.util.*;

public class GBus
{
	public static void main(String args[])
	{
		Scanner kbd = new Scanner(new File(args[0]));

		int T = kbd.nextInt();
		int testCaseNumber = 0;

		while (testCaseNumber < T)
		{
			int N = kbd.nextInt();

			String[] c = kbd.nextLine().str.split("\\s");
			int<> cities = new int<>;
			for (int i = 0; i < c.length; i++)
				cities.add(Integer.parseInt(c[i]));

			Collections.sort(cities);

			








		}

	}
}