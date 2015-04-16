// This class finds the largest prime factor of the number
// 600851475143
import java.util.ArrayList;

public class Problem3
{
  
	final static long NUMBER_TO_FACTOR = 600851475143L;

	public static void main(String args[])
	{
	    long start = System.currentTimeMillis();
		ArrayList<Long> factors = new ArrayList<Long>();

		findFactors(factors);

		// Displays all the factors of NUMBER_TO_FACTOR
		for(int i = 0; i < factors.size(); i++)
			System.out.println(i + ") " + factors.get(i));

		findPrimes(factors);

		// Displays the largest prime factor of NUMBER_TO_FACTOR
		System.out.println(factors.get(factors.size() - 1));

		// Displays the execution time
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}

	// Finds all the factors of NUMBER_TO_FACTOR
	public static void findFactors(ArrayList<Long> list)
	{
		for(long factor = 3L; factor <= Math.sqrt(NUMBER_TO_FACTOR); factor += 2)
		{
			if(NUMBER_TO_FACTOR % factor == 0)
				list.add(new Long(factor));
		}
	}

	// Find all the prime numbers from the list of factors.
	// We are using all the odd-valued integers, up to sqrt(largestFactor)
	// since it is quicker than computing all the prime numbers.
	// We also omitted 2 from the list of primes because we know that the
	// factor is odd and not divisible by 2
	public static void findPrimes(ArrayList<Long> list)
	{
		long largestFactor = list.get(list.size() - 1);

		for(int i = list.size() - 1; i >= 0; i--)
		{
			for(long j = 3L; j <= Math.sqrt(largestFactor); j += 2)
			{
				if(list.get(i) % j == 0)
				{
					list.remove(i);
					break;
				}
			}
		}
	}
}