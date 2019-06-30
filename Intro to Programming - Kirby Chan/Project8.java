import java.io.*;

public class Project8
{
	public static void main( String[] args )
	{
		int rows = 5;
		System.out.format("%d row triangle tree contains %d stars\n", rows, triStars(rows) );
		
		// S U M D I G I T S
		int number = 12345;
		System.out.format("sum of digits in %d = %d\n", number, sumDigits( number ) );
		
		// C O U N T 7 S
		number = 713274772;
		System.out.format("%d occurances of digit 7 in %d\n", count7s(number), number );
		
		// C O U N T 8 S -but- there is a twist! Any 8 with an 8 to its left counts as TWO 8s
		number = 82338828;
		System.out.format("%d occurances** of digit 8 in %d\n", count8s(number), number );

		// P O W E R N
		int base=2,exponent=8;
		System.out.format("%d to the power %d = %d\n", base, exponent, powerN(base,exponent) );	

		// I S S O R T E D 
		int[] array = { 7, 8, 12, 20, 21, 22, 37, 41, 55, 60, 65, 74, 83, 84, 87 };
		int startingAt=0;
		boolean isSorted = isSorted( array, startingAt, array.length );
		System.out.print( "array: ");
		for ( int i=0 ; i<array.length ; ++i ) System.out.print( array[i] + " " );
		if (isSorted)
			System.out.println(" is SORTED" );	
		else
			System.out.println(" is NOT SORTED" );	

		// P A L I N D R O M E
		String s = "stanleyyelnats";
		if ( isPalindrome( s, 0, s.length()-1 ) )
			System.out.format("%s IS a palindrome\n", s );	
		else
			System.out.format("\n%s NOT a palindrome\n", s ); 	
		
	} // END MAIN

	static int triStars(int rows)  
	{	
		if (rows == 0) return 0;
		
		return rows + triStars(rows-1);
	}

	static int sumDigits(int n) 
	{	
		if (n==0) return 0;
		
		return (n%10) + sumDigits(n/10);
	}

	static int count7s(int n) 
	{	
		if (n==0) return 0;
		
		if (n%10 == 7)
			return 1 + count7s(n/10);
		return count7s(n/10);
	}
	
	static int count8s(int n) 
	{	
		if (n==0) return 0;
		
		if (n%10 == 8 && n%100 == 8) 
			return 2 + count8s(n/10);
		else if (n%10 == 8) 
			return 1 + count8s(n/10);
		return count8s(n/10);
	}

	static int powerN(int base, int n) 
	{	
		if (n==0) return 1;
		return base * powerN(base,n-1);
	}

	static boolean isSorted(int array[], int i, int count ) 
	{	
		if (i==count-1) return true;
		
		if (array[i]>array[i+1]) return false;
		return isSorted(array,i+1,count);
	}

	static boolean isPalindrome(String s, int lo, int hi ) 
	{	
		if (lo >= hi) return true;

		if (s.charAt(lo) != s.charAt(hi)) return false;
		return isPalindrome(s, lo+1, hi-1);
	}
} // END CLASS Project8