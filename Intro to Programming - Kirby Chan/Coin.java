
import java.util.Random;

public class Coin
{
	private Random rdm;
	private int headCount, tailCount;

	public Coin( int seed )
	{
		rdm = new Random( seed );
		reset();
	}

	public String flip()
	{
		int coin = rdm.nextInt(2);
		if (coin == 0)
		{
			setNumTails( getNumTails() + 1);
			return "T";
		}
		else
		{
			setNumHeads( getNumHeads() + 1);
			return "H";
		}
	}

	public int getNumHeads()
	{
		return headCount;
	}
	public int getNumTails()
	{
		return tailCount;
	}
	private void setNumHeads(int n)
	{
		if(n >= 0)
		{
			headCount = n;
		}
	}
	private void setNumTails(int n)
	{
		if(n >= 0)
		{
			tailCount = n;
		}
	}
	public void reset()
	{
		setNumTails(0);
		setNumHeads(0);
	}
} // END COIN CLASS