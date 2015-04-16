// Largest product in a series
// Find the value of the product of thirteen adjacent
// digits with the largest product
import java.io.*;

public class Problem08
{
	private static final String FILE = "/home/aaron/Documents/Git/Euler/Files/Problem08.txt";
	private static final int SIZE = 1000;
	private static long largestProduct = 0L;
	private static long[] array;
	private static long[] product;

	public static void main(String args[])
	{
		try
		{
			long start = System.currentTimeMillis();
			array = new long[SIZE];
			product = new long[SIZE - 12];
			
			readFile();

			// Create a moving window that calculates the products of the 13 adjacent digits
			for(int j = 0; j < product.length; j++)
			{
				product[j] = array[j] * 
							 array[j + 1] * array[j + 2] * array[j + 3] * 
							 array[j + 4] * array[j + 5] * array[j + 6] * 
							 array[j + 7] * array[j + 8] * array[j + 9] *
							 array[j + 10] * array[j + 11] * array[j + 12];

				if(product[j] > largestProduct)
					largestProduct = product[j];
			}

			System.out.println(largestProduct);
			System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	// Read through the file and fill the array
	private static void readFile() throws IOException
	{
		FileReader fr = new FileReader(FILE);
		int ch = -1;

		for(int i = 0; i < SIZE; i++)
		{
			ch = fr.read() - 48;
			
			if(ch < 0)
				ch = fr.read() - 48;
			
			array[i] = ch;
		}

		fr.close();
	}
}