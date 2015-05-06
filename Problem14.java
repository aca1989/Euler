// Longest Collatz sequence
// Which starting number, under one million, produces the longest chain?

public class Problem14
{
	public static final int MAX = 1000000;
	public static long[] range = new long[MAX];
	
	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		
		System.out.println(findLongestChain());

		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
	
	// Find the longest Collatz chain
	public static long findLongestChain()
	{
		long number = 1;
		long currentMaxChain = 1;

		for(long i = 2; i < MAX; i++)
		{
			if(i % 2 == 0)
			{
				if(even(i) > currentMaxChain)
				{
					currentMaxChain = even(i);
					number = i;
				}
			}
			else
			{
				if(odd(i) > currentMaxChain)
				{
					currentMaxChain = odd(i);
					number = i;
				}
			}
		}

		return number;
	}
	
	// If the number is even then use this function to find the length
	// of the chain
	public static long even(long i)
	{
		if(range[(int) i] != 0)
			return range[(int) i];
		else
		{
			long next = i / 2;

			if(next >= MAX)
			{
				if(next % 2 == 0)
					range[(int) i] = 1 + evenOut(next);
				else
					range[(int) i] = 1 + oddOut(next);
			}
			else
			{
				if(next % 2 == 0)
					range[(int) i] = 1 + even(next);
				else
					range[(int) i] = 1 + odd(next);
			}

			return range[(int) i];
		}
	}
	
	// If the number is odd then use this function to find the length
	// of the chain
	public static long odd(long i)
	{
		if(i == 1)
			return 1;

		if(range[(int) i] != 0)
			return range[(int) i];
		else
		{
			long next = 3 * i + 1;

			if(next >= MAX)
			{
				if(next % 2 == 0)
					range[(int) i] = 1 + evenOut(next);
				else
					range[(int) i] = 1 + oddOut(next);
			}
			else
			{
				if(next % 2 == 0)
					range[(int) i] = 1 + even(next);
				else
					range[(int) i] = 1 + odd(next);
			}

			return range[(int) i];
		}
	}
	
	// Use this function if the number is even and exceeds our MAX
	// Basically the same as even()
	public static long evenOut(long i)
	{
		long next = i / 2;
		long temp = 0;

		if(next >= MAX)
		{
			if(next % 2 == 0)
				temp = 1 + evenOut(next);
			else
				temp = 1 + oddOut(next);
		}
		else
		{
			if(next % 2 == 0)
				temp = 1 + even(next);
			else
				temp = 1 + odd(next);
		}

		return temp;
	}
	
	// Use this function if the number is odd and exceeds our MAX
	// Basically the same as odd()
	public static long oddOut(long i)
	{
		long next = 3 * i + 1;
		long temp = 0;

		if(next >= MAX)
		{
			if(next % 2 == 0)
				temp = 1 + evenOut(next);
			else
				temp = 1 + oddOut(next);
		}
		else
		{
			if(next % 2 == 0)
				temp = 1 + even(next);
			else
				temp = 1 + odd(next);
		}

		return temp;
	}
}