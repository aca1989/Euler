// Special Pythagorean triplet
// a < b < c && a + b + c == 1000
// a^2 + b^2 == c ^2

public class Problem09
{
	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		int product = -1;
		boolean found = false;

		for(int c = 5; c < 1000 && !found; c++)
			for(int b = 4; b < c && !found; b++)
				for(int a = 3; a < b && !found; a++)
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && (a + b + c == 1000))
					{
						product = a * b * c;
						found = true;
					}

		System.out.println(product);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
}