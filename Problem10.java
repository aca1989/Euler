// Summation of primes
// Find the sum of all the primes below two million

public class Problem10
{
	private static final int MAX = 2000000;
	private static long sum = 0;
	private static long[] primes;

	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		int tail = 1;
		primes = new long[1000];
		primes[0] = 2;
		sum += 2;

		for(long i = 3; i < MAX; i += 2)
		{
			for(int j = 0; j < tail; j++)
			{
				if(i % primes[j] == 0)
					break;
				else if(j == (tail - 1))
				{
					if(tail == primes.length)
					{
						long[] temp = new long[primes.length * 2];
						System.arraycopy(primes, 0, temp, 0, primes.length);
						primes = temp;
					}

					primes[tail++] = i;
					sum += i;
				}
			}
		}

		System.out.println(sum);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
}