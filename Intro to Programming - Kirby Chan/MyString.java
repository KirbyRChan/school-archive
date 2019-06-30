public class MyString
{
	static final int NOT_FOUND = -1;
	private char[] letters;
	
	public MyString( String other )
	{	
		letters = other.toCharArray();
	}
	public MyString( MyString other )
	{	
		letters = new char[other.length()];

		for(int i = 0; i < letters.length; i++)
			letters[i] = other.charAt(i);
	}	
	public int length()
	{
		return letters.length;
	}
	public char charAt(int index)
	{
		if (index < letters.length)
			return letters[index];
		else
			return '\0';
	}
	public int compareTo(MyString other)
	{
		for(int i = 0; i<this.length() || i<other.length(); i++)
		{
			if (this.charAt(i) > other.charAt(i))
				return 1;
			else if (this.charAt(i) < other.charAt(i))
				return -1;
		}
		return 0;
	}	
	public boolean equals(MyString other)
	{
		if (this.compareTo(other) == 0)
			return true;
		else
			return false;
	}
	
	public int indexOf(int startIndex, char ch)	
	{
		for (int i = startIndex; i < this.length(); i++)
		{
			if(this.charAt(i) == ch)
				return i;
		}
		return NOT_FOUND;
	}
	private int compareKey(int startIndex, MyString other)
	{
		int i = startIndex;
		for (int k = 0; k < other.length(); k++)	
		{
			if (this.charAt(i) != other.charAt(k))
				return NOT_FOUND;
			i++;
		}
		return startIndex;
	}
	public int indexOf(MyString other)
	{
		int indexOfFirst = indexOf(0, other.charAt(0));

		if(indexOfFirst == NOT_FOUND)
			return NOT_FOUND;

		while(indexOfFirst != NOT_FOUND)
		{
			int compare = this.compareKey(indexOfFirst, other);
			
			if(compare != NOT_FOUND)
				return indexOfFirst;
			else
				indexOfFirst = indexOf((indexOfFirst + 1), other.charAt(0));
		}
		return NOT_FOUND;
		
	}
	public String toString()
	{
		return new String(letters);
	}
} // END MYSTRING CLASS