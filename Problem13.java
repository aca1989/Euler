// Largest sum
// Work out the first ten digits of the sum of the one-hundred 50-digit numbers

import java.io.*;

public class Problem13
{
	private static final String FILE = "Files/Problem13.txt";
	private static final int NUMBER_OF_NUMBERS = 100;
	private static final int DIGITS = 50;
	private static int[][] input = new int[NUMBER_OF_NUMBERS][DIGITS];
	private static int[] carry = new int[DIGITS];
	private static int[] sum = new int[DIGITS];
	
	public static void main(String args[])
	{
		try {
			long start = System.currentTimeMillis();

			getData(FILE);
			addData();
			printSum();

			System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
		} catch (IOException e) {}
	}
	
	// Reads the data from the file and stores it into the array
	public static void getData(String name) throws IOException
	{
		FileReader fr = new FileReader(name);
		int temp;

		for(int i = 0; i < NUMBER_OF_NUMBERS; i++)
		{
			for(int j = 0; j < DIGITS; j++)
			{
				temp = fr.read() - 48;

				// While temp is not a number, get the next character
				while(temp < 0 || temp > 9)
					temp = fr.read() - 48;

				input[i][j] = temp;
			}
		}

		fr.close();
	}
	
	// Adds the data in the array and stores it in the sum
	public static void addData()
	{
		// Execute the addition from right to left
		for(int j = DIGITS - 1; j >= 0; j--)
		{
			// Add the carry to the sum for each digit
			if(j < 49)
				sum[j] += carry[j + 1];

			// Add the individual digits from the input data
			for(int i = 0; i < NUMBER_OF_NUMBERS; i++)
				sum[j] += input[i][j];

			// If the sum for a digit exceeds 9, store anything
			// greater than nine in carry and the remainder in sum
			if(sum[j] > 9)
			{
				carry[j] = (int) Math.floor(sum[j] / 10);
				sum[j] %= 10;
			}
		}
	}

	// Prints the sum
	public static void printSum()
	{
		System.out.print(carry[0]);

		for(int i = 0; i < DIGITS; i++)
			System.out.print(sum[i]);

		System.out.println();
	}
}
