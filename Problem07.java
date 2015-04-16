// 10001st prime
// Find the 10001st prime number

public class Problem07
{
	public static final int MAX = 10001;

	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		int nextPrime = 3;
		int[] primes = new int[MAX];
		int index = 1;					// the index of the array where the next prime goes
		primes[0] = 2;

		while(index < MAX)
		{
			for(int i = 0; i < index; i++)
			{
				if(nextPrime % primes[i] == 0)
					break;
				else if(i == (index - 1))
				{
					primes[index] = nextPrime;
					index++;
				}
			}
			nextPrime += 2;
		}

		System.out.println(primes[primes.length - 1]);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
}