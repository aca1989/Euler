// This class finds the sum off all even-valued terms of the Fibonacci
// sequence whose values do not exceed four million

public class Problem02
{

    public static void main(String args[])
    {
    	long start = System.currentTimeMillis();
		int MAX_VALUE = 4000000;
		int first = 1;
		int second = 2;
		int current = first + second;
		int sum = 2;

		while(current < MAX_VALUE)
		{
			if(current % 2 == 0)
				sum += current;
			first = second;
			second = current;
			current = first + second;
		}

		System.out.println(sum);
		System.out.println("Executed in: " + (System.currentTimeMillis() - start) + "ms");
    }
}