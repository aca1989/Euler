// Find the smallest number that is evenly divisible by the numbers 1 to 20

public class Problem05
{
	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		boolean found = false;
		long smallestMultiple = 2500;

		while(!found)
		{
			smallestMultiple++;
			for(int i = 2; i < 21; i++)
			{
				if(smallestMultiple % i != 0)
					break;
				else if(i == 20)
					found = true;
			}
		}

		System.out.println(smallestMultiple);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
}