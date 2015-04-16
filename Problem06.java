// Sum square difference
// Find the difference between the sum of the square and the
// square of the sum of the first 100 digits

public class Problem06
{
	public static void main(String args[])
	{
		long start = System.currentTimeMillis();
		double sum = 0;
		double sumOfSquare = 0, squareOfSum = 0;

		for(long i = 1; i <= 100; i++)
			sumOfSquare += Math.pow(i, 2);

		for(long j = 1; j <= 100; j++)
			sum += j;

		squareOfSum = Math.pow(sum, 2.0);

		System.out.println(squareOfSum - sumOfSquare);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
	}
}