// Highest divisible triangular number
// What is the value of the first triangle number to have over five hundred divisors?

public class Problem12
{
	private static final int NUMBER_OF_DIVISORS = 500;
	private static long n = 1;
	private static long triangleNumber = 0;		// The nth triangle number
	private static long divisors = 0;			// Number of divisors for current triangle number

	public static void main(String args[])
	{
		long start = System.currentTimeMillis();

		do
		{
			divisors = 0;
			triangleNumber += n++;

			for(int div = 1; div <= Math.sqrt(triangleNumber); div++)
			{
				if(triangleNumber % div == 0)
				{
					if(div != Math.sqrt(triangleNumber))
						divisors += 2;
					else
						divisors++;
				}
			}
		} while(divisors <= NUMBER_OF_DIVISORS);

		System.out.println(triangleNumber);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
}