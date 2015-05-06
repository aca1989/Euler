// Power digit sum
// What is the sum of the digits of the number 2^1000?

import java.io.*;
import java.math.*;

public class Problem16
{
	private static BigInteger number;
	private static long sum = 0;
	
	public static void main(String args[])
	{
		long start = System.currentTimeMillis();

		number = new BigInteger("2");
		number = number.pow(1000);

		getSum();
		System.out.println(sum);

		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
	
	// Stores the sum of the digits in sum
	public static void getSum()
	{
		// While number is greater than 0, add the value of the one's place
		// to sum and divide number by ten
		while(number.compareTo(BigInteger.valueOf(0)) > 0)
		{
			sum += number.remainder(new BigInteger("10")).longValue();
			number = number.divide(new BigInteger("10"));
		}
	}
}
