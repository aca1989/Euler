// Largest product in a grid
// What is the greatest product of four adjacent numbers in the same 
// direction (up, down, left, right, or diagonally) in the 20×20 grid?

import java.io.*;
import java.util.*;

public class Problem11
{
	private static final String FILE = "/home/aaron/Documents/Git/Euler/Files/Problem11.txt";
	private static final int ROW = 20;
	private static final int COL = 20;
	private static int[][] grid;
	private static int largestProduct = -1;

	public static void main(String args[])
	{
		try
		{
			long start = System.currentTimeMillis();
			grid = new int[ROW][COL];

			readFile();
			findProduct();

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

	// Read the file and stores the values into a two-dimensional array
	private static void readFile() throws IOException
	{
		FileReader fr = new FileReader(FILE);
		Scanner sc = new Scanner(fr);
		String entry = "";

		for(int col = 0; col < 20; col++)
		{
			for(int row = 0; row < 20; row++)
			{	
				entry = sc.next("[0-9][0-9]");
				grid[row][col] = Integer.parseInt(entry);
			}
		}

		sc.close();
		fr.close();
	}

	// Finds the product of every four adjacent numbers in the grid
	private static void findProduct()
	{
		findHorizontalProduct();
		findVerticalProduct();
		findDiagonalProduct();
	}

	private static void findHorizontalProduct()
	{
		int currentProduct = 0;

		for(int row = 0; row < ROW; row++)
		{
			for(int col = 0; col < COL - 3; col++)
			{
				currentProduct = grid[row][col] * grid[row][col+1] * grid[row][col+2] * grid[row][col+3];
				if(currentProduct > largestProduct)
					largestProduct = currentProduct;
			}
		}
	}

	private static void findVerticalProduct()
	{
		int currentProduct = 0;

		for(int row = 0; row < ROW - 3; row++)
		{
			for(int col = 0; col < COL; col++)
			{
				currentProduct = grid[row][col] * grid[row+1][col] * grid[row+2][col] * grid[row+3][col];
				if(currentProduct > largestProduct)
					largestProduct = currentProduct;
			}
		}
	}

	private static void findDiagonalProduct()
	{
		int currentProduct = 0;

		// Top-left to Bottom-right
		for(int row = 0; row < ROW - 3; row++)
		{
			for(int col = 0; col < COL - 3; col++)
			{
				currentProduct = grid[row][col] * grid[row+1][col+1] * grid[row+2][col+2] * grid[row+3][col+3];
				if(currentProduct > largestProduct)
					largestProduct = currentProduct;
			}
		}

		// Top-right to Bottom-left
		for(int row = 0; row < ROW - 3; row++)
		{
			for(int col = COL - 1; col > 2; col--)
			{
				currentProduct = grid[row][col] * grid[row+1][col-1] * grid[row+2][col-2] * grid[row+3][col-3];
				if(currentProduct > largestProduct)
					largestProduct = currentProduct;
			}
		}
	}
}