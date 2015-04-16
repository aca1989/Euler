// Find the largest palindrome made from the product of two 3-digit numbers

public class Problem04
{
	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		int digit1, digit2, product = 0, largestPalindrome = 0;
		int[] forward = new int[6];
		int[] backward = new int[6];

		for(digit1 = 999; digit1 > 0; digit1--)
		{
			for(digit2 = 999; digit2 > 0; digit2--)
			{
				product = digit1 * digit2;
				int temp = product;

				for(int i = 5; i >= 0; i--)
				{
					forward[i] = temp % 10;
					backward[5 - i] = forward[i];
					temp /= 10;
				}

				if(forward[0] == backward[0] && forward[1] == backward[1] &&
				   forward[2] == backward[2] && forward[3] == backward[3] &&
				   forward[4] == backward[4] && forward[5] == backward[5])
				{
					if(product > largestPalindrome)
						largestPalindrome = product;
				}
			}
		}
		
		System.out.println(largestPalindrome);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
}